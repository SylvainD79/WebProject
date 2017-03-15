package webProject;

import webProject.PMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JDOCursorHelper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

@Api(name = "highscoreentityendpoint", namespace = @ApiNamespace(ownerDomain = "mycompany.com", ownerName = "mycompany.com", packagePath = "services"))
public class HighScoreEntityEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listHighScoreEntity")
	public CollectionResponse<HighScoreEntity> listHighScoreEntity(@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<HighScoreEntity> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(HighScoreEntity.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<HighScoreEntity>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (HighScoreEntity obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<HighScoreEntity>builder().setItems(execute).setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getHighScoreEntity")
	public HighScoreEntity getHighScoreEntity(@Named("id") String id) {
		PersistenceManager mgr = getPersistenceManager();
		HighScoreEntity highscoreentity = null;
		try {
			highscoreentity = mgr.getObjectById(HighScoreEntity.class, id);
		} finally {
			mgr.close();
		}
		return highscoreentity;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param highscoreentity the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertHighScoreEntity")
	public HighScoreEntity insertHighScoreEntity(HighScoreEntity highscoreentity) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (containsHighScoreEntity(highscoreentity)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.makePersistent(highscoreentity);
		} finally {
			mgr.close();
		}
		return highscoreentity;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param highscoreentity the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateHighScoreEntity")
	public HighScoreEntity updateHighScoreEntity(HighScoreEntity highscoreentity) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsHighScoreEntity(highscoreentity)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(highscoreentity);
		} finally {
			mgr.close();
		}
		return highscoreentity;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeHighScoreEntity")
	public void removeHighScoreEntity(@Named("id") Long id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			HighScoreEntity highscoreentity = mgr.getObjectById(HighScoreEntity.class, id);
			mgr.deletePersistent(highscoreentity);
		} finally {
			mgr.close();
		}
	}
	
	@ApiMethod(name = "insertOrUpdateHighScoreEntity")
	public void insertOrUpdateHighScoreEntity(HighScoreEntity highscoreentity) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsHighScoreEntity(highscoreentity)) {
				insertHighScoreEntity(highscoreentity);
			} else {
				HighScoreEntity highscoreentityExist = getHighScoreEntity(highscoreentity.id);
				if (highscoreentityExist.topic.equals(highscoreentity.topic)) {
					if (highscoreentityExist.score < highscoreentity.score) {
						updateHighScoreEntity(highscoreentity);
					} else if (highscoreentityExist.score == highscoreentity.score) {
						if (highscoreentityExist.minutes > highscoreentity.minutes) {
							updateHighScoreEntity(highscoreentity);
						} else if (highscoreentityExist.minutes == highscoreentity.minutes) {
							if (highscoreentityExist.seconds > highscoreentity.seconds) {
								updateHighScoreEntity(highscoreentity);
							}
						}
					}
				} else {
					insertHighScoreEntity(highscoreentity);
				}
			}
		} finally {
			mgr.close();
		}
	}

	private boolean containsHighScoreEntity(HighScoreEntity highscoreentity) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(HighScoreEntity.class, highscoreentity.getId());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

}
