/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2017-02-15 17:18:02 UTC)
 * on 2017-03-16 at 07:10:03 UTC 
 * Modify at your own risk.
 */

package com.mycompany.services.highscoreentityendpoint;

/**
 * Service definition for Highscoreentityendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link HighscoreentityendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Highscoreentityendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.21.0 of the highscoreentityendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://whosaidthatontwitter.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "highscoreentityendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Highscoreentityendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Highscoreentityendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getHighScoreEntity".
   *
   * This request holds the parameters needed by the highscoreentityendpoint server.  After setting
   * any optional parameters, call the {@link GetHighScoreEntity#execute()} method to invoke the
   * remote operation.
   *
   * @param id
   * @return the request
   */
  public GetHighScoreEntity getHighScoreEntity(java.lang.String id) throws java.io.IOException {
    GetHighScoreEntity result = new GetHighScoreEntity(id);
    initialize(result);
    return result;
  }

  public class GetHighScoreEntity extends HighscoreentityendpointRequest<com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity> {

    private static final String REST_PATH = "highscoreentity/{id}";

    /**
     * Create a request for the method "getHighScoreEntity".
     *
     * This request holds the parameters needed by the the highscoreentityendpoint server.  After
     * setting any optional parameters, call the {@link GetHighScoreEntity#execute()} method to invoke
     * the remote operation. <p> {@link GetHighScoreEntity#initialize(com.google.api.client.googleapis
     * .services.AbstractGoogleClientRequest)} must be called to initialize this instance immediately
     * after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetHighScoreEntity(java.lang.String id) {
      super(Highscoreentityendpoint.this, "GET", REST_PATH, null, com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetHighScoreEntity setAlt(java.lang.String alt) {
      return (GetHighScoreEntity) super.setAlt(alt);
    }

    @Override
    public GetHighScoreEntity setFields(java.lang.String fields) {
      return (GetHighScoreEntity) super.setFields(fields);
    }

    @Override
    public GetHighScoreEntity setKey(java.lang.String key) {
      return (GetHighScoreEntity) super.setKey(key);
    }

    @Override
    public GetHighScoreEntity setOauthToken(java.lang.String oauthToken) {
      return (GetHighScoreEntity) super.setOauthToken(oauthToken);
    }

    @Override
    public GetHighScoreEntity setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetHighScoreEntity) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetHighScoreEntity setQuotaUser(java.lang.String quotaUser) {
      return (GetHighScoreEntity) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetHighScoreEntity setUserIp(java.lang.String userIp) {
      return (GetHighScoreEntity) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String id;

    /**

     */
    public java.lang.String getId() {
      return id;
    }

    public GetHighScoreEntity setId(java.lang.String id) {
      this.id = id;
      return this;
    }

    @Override
    public GetHighScoreEntity set(String parameterName, Object value) {
      return (GetHighScoreEntity) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertHighScoreEntity".
   *
   * This request holds the parameters needed by the highscoreentityendpoint server.  After setting
   * any optional parameters, call the {@link InsertHighScoreEntity#execute()} method to invoke the
   * remote operation.
   *
   * @param content the {@link com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity}
   * @return the request
   */
  public InsertHighScoreEntity insertHighScoreEntity(com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity content) throws java.io.IOException {
    InsertHighScoreEntity result = new InsertHighScoreEntity(content);
    initialize(result);
    return result;
  }

  public class InsertHighScoreEntity extends HighscoreentityendpointRequest<com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity> {

    private static final String REST_PATH = "highscoreentity";

    /**
     * Create a request for the method "insertHighScoreEntity".
     *
     * This request holds the parameters needed by the the highscoreentityendpoint server.  After
     * setting any optional parameters, call the {@link InsertHighScoreEntity#execute()} method to
     * invoke the remote operation. <p> {@link InsertHighScoreEntity#initialize(com.google.api.client.
     * googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity}
     * @since 1.13
     */
    protected InsertHighScoreEntity(com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity content) {
      super(Highscoreentityendpoint.this, "POST", REST_PATH, content, com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity.class);
    }

    @Override
    public InsertHighScoreEntity setAlt(java.lang.String alt) {
      return (InsertHighScoreEntity) super.setAlt(alt);
    }

    @Override
    public InsertHighScoreEntity setFields(java.lang.String fields) {
      return (InsertHighScoreEntity) super.setFields(fields);
    }

    @Override
    public InsertHighScoreEntity setKey(java.lang.String key) {
      return (InsertHighScoreEntity) super.setKey(key);
    }

    @Override
    public InsertHighScoreEntity setOauthToken(java.lang.String oauthToken) {
      return (InsertHighScoreEntity) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertHighScoreEntity setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertHighScoreEntity) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertHighScoreEntity setQuotaUser(java.lang.String quotaUser) {
      return (InsertHighScoreEntity) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertHighScoreEntity setUserIp(java.lang.String userIp) {
      return (InsertHighScoreEntity) super.setUserIp(userIp);
    }

    @Override
    public InsertHighScoreEntity set(String parameterName, Object value) {
      return (InsertHighScoreEntity) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listHighScoreEntity".
   *
   * This request holds the parameters needed by the highscoreentityendpoint server.  After setting
   * any optional parameters, call the {@link ListHighScoreEntity#execute()} method to invoke the
   * remote operation.
   *
   * @return the request
   */
  public ListHighScoreEntity listHighScoreEntity() throws java.io.IOException {
    ListHighScoreEntity result = new ListHighScoreEntity();
    initialize(result);
    return result;
  }

  public class ListHighScoreEntity extends HighscoreentityendpointRequest<com.mycompany.services.highscoreentityendpoint.model.CollectionResponseHighScoreEntity> {

    private static final String REST_PATH = "highscoreentity";

    /**
     * Create a request for the method "listHighScoreEntity".
     *
     * This request holds the parameters needed by the the highscoreentityendpoint server.  After
     * setting any optional parameters, call the {@link ListHighScoreEntity#execute()} method to
     * invoke the remote operation. <p> {@link ListHighScoreEntity#initialize(com.google.api.client.go
     * ogleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListHighScoreEntity() {
      super(Highscoreentityendpoint.this, "GET", REST_PATH, null, com.mycompany.services.highscoreentityendpoint.model.CollectionResponseHighScoreEntity.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListHighScoreEntity setAlt(java.lang.String alt) {
      return (ListHighScoreEntity) super.setAlt(alt);
    }

    @Override
    public ListHighScoreEntity setFields(java.lang.String fields) {
      return (ListHighScoreEntity) super.setFields(fields);
    }

    @Override
    public ListHighScoreEntity setKey(java.lang.String key) {
      return (ListHighScoreEntity) super.setKey(key);
    }

    @Override
    public ListHighScoreEntity setOauthToken(java.lang.String oauthToken) {
      return (ListHighScoreEntity) super.setOauthToken(oauthToken);
    }

    @Override
    public ListHighScoreEntity setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListHighScoreEntity) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListHighScoreEntity setQuotaUser(java.lang.String quotaUser) {
      return (ListHighScoreEntity) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListHighScoreEntity setUserIp(java.lang.String userIp) {
      return (ListHighScoreEntity) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListHighScoreEntity setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Integer limit;

    /**

     */
    public java.lang.Integer getLimit() {
      return limit;
    }

    public ListHighScoreEntity setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListHighScoreEntity set(String parameterName, Object value) {
      return (ListHighScoreEntity) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "manageHighScoreEntity".
   *
   * This request holds the parameters needed by the highscoreentityendpoint server.  After setting
   * any optional parameters, call the {@link ManageHighScoreEntity#execute()} method to invoke the
   * remote operation.
   *
   * @param content the {@link com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity}
   * @return the request
   */
  public ManageHighScoreEntity manageHighScoreEntity(com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity content) throws java.io.IOException {
    ManageHighScoreEntity result = new ManageHighScoreEntity(content);
    initialize(result);
    return result;
  }

  public class ManageHighScoreEntity extends HighscoreentityendpointRequest<Void> {

    private static final String REST_PATH = "manageHighScoreEntity";

    /**
     * Create a request for the method "manageHighScoreEntity".
     *
     * This request holds the parameters needed by the the highscoreentityendpoint server.  After
     * setting any optional parameters, call the {@link ManageHighScoreEntity#execute()} method to
     * invoke the remote operation. <p> {@link ManageHighScoreEntity#initialize(com.google.api.client.
     * googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity}
     * @since 1.13
     */
    protected ManageHighScoreEntity(com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity content) {
      super(Highscoreentityendpoint.this, "POST", REST_PATH, content, Void.class);
    }

    @Override
    public ManageHighScoreEntity setAlt(java.lang.String alt) {
      return (ManageHighScoreEntity) super.setAlt(alt);
    }

    @Override
    public ManageHighScoreEntity setFields(java.lang.String fields) {
      return (ManageHighScoreEntity) super.setFields(fields);
    }

    @Override
    public ManageHighScoreEntity setKey(java.lang.String key) {
      return (ManageHighScoreEntity) super.setKey(key);
    }

    @Override
    public ManageHighScoreEntity setOauthToken(java.lang.String oauthToken) {
      return (ManageHighScoreEntity) super.setOauthToken(oauthToken);
    }

    @Override
    public ManageHighScoreEntity setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ManageHighScoreEntity) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ManageHighScoreEntity setQuotaUser(java.lang.String quotaUser) {
      return (ManageHighScoreEntity) super.setQuotaUser(quotaUser);
    }

    @Override
    public ManageHighScoreEntity setUserIp(java.lang.String userIp) {
      return (ManageHighScoreEntity) super.setUserIp(userIp);
    }

    @Override
    public ManageHighScoreEntity set(String parameterName, Object value) {
      return (ManageHighScoreEntity) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeHighScoreEntity".
   *
   * This request holds the parameters needed by the highscoreentityendpoint server.  After setting
   * any optional parameters, call the {@link RemoveHighScoreEntity#execute()} method to invoke the
   * remote operation.
   *
   * @param id
   * @return the request
   */
  public RemoveHighScoreEntity removeHighScoreEntity(java.lang.Long id) throws java.io.IOException {
    RemoveHighScoreEntity result = new RemoveHighScoreEntity(id);
    initialize(result);
    return result;
  }

  public class RemoveHighScoreEntity extends HighscoreentityendpointRequest<Void> {

    private static final String REST_PATH = "highscoreentity/{id}";

    /**
     * Create a request for the method "removeHighScoreEntity".
     *
     * This request holds the parameters needed by the the highscoreentityendpoint server.  After
     * setting any optional parameters, call the {@link RemoveHighScoreEntity#execute()} method to
     * invoke the remote operation. <p> {@link RemoveHighScoreEntity#initialize(com.google.api.client.
     * googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveHighScoreEntity(java.lang.Long id) {
      super(Highscoreentityendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveHighScoreEntity setAlt(java.lang.String alt) {
      return (RemoveHighScoreEntity) super.setAlt(alt);
    }

    @Override
    public RemoveHighScoreEntity setFields(java.lang.String fields) {
      return (RemoveHighScoreEntity) super.setFields(fields);
    }

    @Override
    public RemoveHighScoreEntity setKey(java.lang.String key) {
      return (RemoveHighScoreEntity) super.setKey(key);
    }

    @Override
    public RemoveHighScoreEntity setOauthToken(java.lang.String oauthToken) {
      return (RemoveHighScoreEntity) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveHighScoreEntity setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveHighScoreEntity) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveHighScoreEntity setQuotaUser(java.lang.String quotaUser) {
      return (RemoveHighScoreEntity) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveHighScoreEntity setUserIp(java.lang.String userIp) {
      return (RemoveHighScoreEntity) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveHighScoreEntity setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveHighScoreEntity set(String parameterName, Object value) {
      return (RemoveHighScoreEntity) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateHighScoreEntity".
   *
   * This request holds the parameters needed by the highscoreentityendpoint server.  After setting
   * any optional parameters, call the {@link UpdateHighScoreEntity#execute()} method to invoke the
   * remote operation.
   *
   * @param content the {@link com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity}
   * @return the request
   */
  public UpdateHighScoreEntity updateHighScoreEntity(com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity content) throws java.io.IOException {
    UpdateHighScoreEntity result = new UpdateHighScoreEntity(content);
    initialize(result);
    return result;
  }

  public class UpdateHighScoreEntity extends HighscoreentityendpointRequest<com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity> {

    private static final String REST_PATH = "highscoreentity";

    /**
     * Create a request for the method "updateHighScoreEntity".
     *
     * This request holds the parameters needed by the the highscoreentityendpoint server.  After
     * setting any optional parameters, call the {@link UpdateHighScoreEntity#execute()} method to
     * invoke the remote operation. <p> {@link UpdateHighScoreEntity#initialize(com.google.api.client.
     * googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity}
     * @since 1.13
     */
    protected UpdateHighScoreEntity(com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity content) {
      super(Highscoreentityendpoint.this, "PUT", REST_PATH, content, com.mycompany.services.highscoreentityendpoint.model.HighScoreEntity.class);
    }

    @Override
    public UpdateHighScoreEntity setAlt(java.lang.String alt) {
      return (UpdateHighScoreEntity) super.setAlt(alt);
    }

    @Override
    public UpdateHighScoreEntity setFields(java.lang.String fields) {
      return (UpdateHighScoreEntity) super.setFields(fields);
    }

    @Override
    public UpdateHighScoreEntity setKey(java.lang.String key) {
      return (UpdateHighScoreEntity) super.setKey(key);
    }

    @Override
    public UpdateHighScoreEntity setOauthToken(java.lang.String oauthToken) {
      return (UpdateHighScoreEntity) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateHighScoreEntity setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateHighScoreEntity) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateHighScoreEntity setQuotaUser(java.lang.String quotaUser) {
      return (UpdateHighScoreEntity) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateHighScoreEntity setUserIp(java.lang.String userIp) {
      return (UpdateHighScoreEntity) super.setUserIp(userIp);
    }

    @Override
    public UpdateHighScoreEntity set(String parameterName, Object value) {
      return (UpdateHighScoreEntity) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Highscoreentityendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Highscoreentityendpoint}. */
    @Override
    public Highscoreentityendpoint build() {
      return new Highscoreentityendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link HighscoreentityendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setHighscoreentityendpointRequestInitializer(
        HighscoreentityendpointRequestInitializer highscoreentityendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(highscoreentityendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
