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

package com.mycompany.services.highscoreentityendpoint.model;

/**
 * Model definition for HighScoreEntity.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the highscoreentityendpoint. For a detailed explanation
 * see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class HighScoreEntity extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer minutes;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String name;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer score;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer seconds;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String topic;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public HighScoreEntity setId(java.lang.String id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getMinutes() {
    return minutes;
  }

  /**
   * @param minutes minutes or {@code null} for none
   */
  public HighScoreEntity setMinutes(java.lang.Integer minutes) {
    this.minutes = minutes;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getName() {
    return name;
  }

  /**
   * @param name name or {@code null} for none
   */
  public HighScoreEntity setName(java.lang.String name) {
    this.name = name;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getScore() {
    return score;
  }

  /**
   * @param score score or {@code null} for none
   */
  public HighScoreEntity setScore(java.lang.Integer score) {
    this.score = score;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getSeconds() {
    return seconds;
  }

  /**
   * @param seconds seconds or {@code null} for none
   */
  public HighScoreEntity setSeconds(java.lang.Integer seconds) {
    this.seconds = seconds;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getTopic() {
    return topic;
  }

  /**
   * @param topic topic or {@code null} for none
   */
  public HighScoreEntity setTopic(java.lang.String topic) {
    this.topic = topic;
    return this;
  }

  @Override
  public HighScoreEntity set(String fieldName, Object value) {
    return (HighScoreEntity) super.set(fieldName, value);
  }

  @Override
  public HighScoreEntity clone() {
    return (HighScoreEntity) super.clone();
  }

}
