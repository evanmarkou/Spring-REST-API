DROP TABLE IF EXISTS SensorHeartbeat;
DROP TABLE IF EXISTS SensorEmotion;
DROP TABLE IF EXISTS SensorSweat;
DROP TABLE IF EXISTS SensorAudio;
DROP TABLE IF EXISTS SurveyBelbin;
DROP TABLE IF EXISTS SurveyMbti;
DROP TABLE IF EXISTS SurveyVak;
DROP TABLE IF EXISTS SurveyPaei;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Role;

CREATE TABLE User (
  userId    VARCHAR(20)  NOT NULL,
  moduleId  INT(11)      NOT NULL,
  roleId    INT(11)      NOT NULL,
  firstName VARCHAR(50)  NOT NULL,
  lastName  VARCHAR(150) NOT NULL,
  email     VARCHAR(200) NOT NULL,
  gender    TINYINT,
  PRIMARY KEY (userId)
);

CREATE TABLE SensorHeartbeat (
  sensorHeartbeatId INT(11)     NOT NULL AUTO_INCREMENT,
  userId            VARCHAR(20) NOT NULL,
  timestamp         TIMESTAMP   NOT NULL,
  rate              TINYINT     NOT NULL,
  PRIMARY KEY (sensorHeartbeatId)
);

CREATE TABLE SensorEmotion (
  sensorEmotionId INT(11)     NOT NULL AUTO_INCREMENT,
  userId          VARCHAR(20) NOT NULL,
  timestamp       TIMESTAMP   NOT NULL,
  dominantEmotion VARCHAR(30) NOT NULL,
  score           TINYINT     NOT NULL,
  PRIMARY KEY (sensorEmotionId)
);

CREATE TABLE SensorSweat (
  sensorSweatId INT(11)     NOT NULL AUTO_INCREMENT,
  userId        VARCHAR(20) NOT NULL,
  timestamp     TIMESTAMP   NOT NULL,
  sweatlevel    TINYINT,
  PRIMARY KEY (sensorSweatId)
);

CREATE TABLE SensorAudio (
  sensorAudioId INT(11)     NOT NULL AUTO_INCREMENT,
  userId        VARCHAR(20) NOT NULL,
  timestamp     TIMESTAMP   NOT NULL,
  angle         TINYINT,
  energy        TINYINT,
  confidence    TINYINT,
  PRIMARY KEY (sensorAudioId)
);

CREATE TABLE SurveyBelbin (
  surveyBelbinId       INT(11)     NOT NULL AUTO_INCREMENT,
  userId               VARCHAR(20) NOT NULL,
  submissionTime       TIMESTAMP   NOT NULL,
  q1a                  SMALLINT(6),
  q1b                  SMALLINT(6),
  q1c                  SMALLINT(6),
  q1d                  SMALLINT(6),
  q1e                  SMALLINT(6),
  q1f                  SMALLINT(6),
  q1g                  SMALLINT(6),
  q1h                  SMALLINT(6),
  q2a                  SMALLINT(6),
  q2b                  SMALLINT(6),
  q2c                  SMALLINT(6),
  q2d                  SMALLINT(6),
  q2e                  SMALLINT(6),
  q2f                  SMALLINT(6),
  q2g                  SMALLINT(6),
  q2h                  SMALLINT(6),
  q3a                  SMALLINT(6),
  q3b                  SMALLINT(6),
  q3c                  SMALLINT(6),
  q3d                  SMALLINT(6),
  q3e                  SMALLINT(6),
  q3f                  SMALLINT(6),
  q3g                  SMALLINT(6),
  q3h                  SMALLINT(6),
  q4a                  SMALLINT(6),
  q4b                  SMALLINT(6),
  q4c                  SMALLINT(6),
  q4d                  SMALLINT(6),
  q4e                  SMALLINT(6),
  q4f                  SMALLINT(6),
  q4g                  SMALLINT(6),
  q4h                  SMALLINT(6),
  q5a                  SMALLINT(6),
  q5b                  SMALLINT(6),
  q5c                  SMALLINT(6),
  q5d                  SMALLINT(6),
  q5e                  SMALLINT(6),
  q5f                  SMALLINT(6),
  q5g                  SMALLINT(6),
  q5h                  SMALLINT(6),
  q6a                  SMALLINT(6),
  q6b                  SMALLINT(6),
  q6c                  SMALLINT(6),
  q6d                  SMALLINT(6),
  q6e                  SMALLINT(6),
  q6f                  SMALLINT(6),
  q6g                  SMALLINT(6),
  q6h                  SMALLINT(6),
  q7a                  SMALLINT(6),
  q7b                  SMALLINT(6),
  q7c                  SMALLINT(6),
  q7d                  SMALLINT(6),
  q7e                  SMALLINT(6),
  q7f                  SMALLINT(6),
  q7g                  SMALLINT(6),
  q7h                  SMALLINT(6),
  implementer          SMALLINT(6),
  coordinator          SMALLINT(6),
  shaper               SMALLINT(6),
  plant                SMALLINT(6),
  resourceinvestigator SMALLINT(6),
  monitorevaluator     SMALLINT(6),
  teamworker           SMALLINT(6),
  completefinisher     SMALLINT(6),
  specialist           SMALLINT(6),
  PRIMARY KEY (surveyBelbinId)
);

CREATE TABLE SurveyMbti (
  surveyMbtiId   INT(11)     NOT NULL AUTO_INCREMENT,
  userId         VARCHAR(20) NOT NULL,
  submissionTime TIMESTAMP   NOT NULL,
  q1             SMALLINT(6),
  q2             SMALLINT(6),
  q3             SMALLINT(6),
  q4             SMALLINT(6),
  q5             SMALLINT(6),
  q6             SMALLINT(6),
  q7             SMALLINT(6),
  q8             SMALLINT(6),
  q9             SMALLINT(6),
  q10            SMALLINT(6),
  q11            SMALLINT(6),
  q12            SMALLINT(6),
  q13            SMALLINT(6),
  q14            SMALLINT(6),
  q15            SMALLINT(6),
  q16            SMALLINT(6),
  q17            SMALLINT(6),
  q18            SMALLINT(6),
  q19            SMALLINT(6),
  q20            SMALLINT(6),
  q21            SMALLINT(6),
  q22            SMALLINT(6),
  q23            SMALLINT(6),
  q24            SMALLINT(6),
  q25            SMALLINT(6),
  q26            SMALLINT(6),
  q27            SMALLINT(6),
  q28            SMALLINT(6),
  q29            SMALLINT(6),
  q30            SMALLINT(6),
  q31            SMALLINT(6),
  q32            SMALLINT(6),
  q33            SMALLINT(6),
  q34            SMALLINT(6),
  q35            SMALLINT(6),
  q36            SMALLINT(6),
  q37            SMALLINT(6),
  q38            SMALLINT(6),
  q39            SMALLINT(6),
  q40            SMALLINT(6),
  q41            SMALLINT(6),
  q42            SMALLINT(6),
  q43            SMALLINT(6),
  q44            SMALLINT(6),
  q45            SMALLINT(6),
  q46            SMALLINT(6),
  q47            SMALLINT(6),
  q48            SMALLINT(6),
  q49            SMALLINT(6),
  q50            SMALLINT(6),
  q51            SMALLINT(6),
  q52            SMALLINT(6),
  q53            SMALLINT(6),
  q54            SMALLINT(6),
  q55            SMALLINT(6),
  q56            SMALLINT(6),
  q57            SMALLINT(6),
  q58            SMALLINT(6),
  q59            SMALLINT(6),
  q60            SMALLINT(6),
  q61            SMALLINT(6),
  q62            SMALLINT(6),
  q63            SMALLINT(6),
  q64            SMALLINT(6),
  q65            SMALLINT(6),
  q66            SMALLINT(6),
  q67            SMALLINT(6),
  q68            SMALLINT(6),
  q69            SMALLINT(6),
  q70            SMALLINT(6),
  e              SMALLINT(6),
  i              SMALLINT(6),
  s              SMALLINT(6),
  n              SMALLINT(6),
  t              SMALLINT(6),
  f              SMALLINT(6),
  j              SMALLINT(6),
  p              SMALLINT(6),
  PRIMARY KEY (surveyMbtiId)
);

CREATE TABLE SurveyVak (
  surveyVakId    INT(11)     NOT NULL AUTO_INCREMENT,
  userId         VARCHAR(20) NOT NULL,
  submissionTime TIMESTAMP   NOT NULL,
  q1             SMALLINT(6),
  q2             SMALLINT(6),
  q3             SMALLINT(6),
  q4             SMALLINT(6),
  q5             SMALLINT(6),
  q6             SMALLINT(6),
  q7             SMALLINT(6),
  q8             SMALLINT(6),
  q9             SMALLINT(6),
  q10            SMALLINT(6),
  q11            SMALLINT(6),
  q12            SMALLINT(6),
  q13            SMALLINT(6),
  q14            SMALLINT(6),
  q15            SMALLINT(6),
  q16            SMALLINT(6),
  q17            SMALLINT(6),
  q18            SMALLINT(6),
  q19            SMALLINT(6),
  q20            SMALLINT(6),
  q21            SMALLINT(6),
  q22            SMALLINT(6),
  q23            SMALLINT(6),
  q24            SMALLINT(6),
  q25            SMALLINT(6),
  q26            SMALLINT(6),
  q27            SMALLINT(6),
  q28            SMALLINT(6),
  q29            SMALLINT(6),
  q30            SMALLINT(6),
  visual         SMALLINT(6),
  auditory       SMALLINT(6),
  kinaesthetic   SMALLINT(6),
  PRIMARY KEY (surveyVakId)
);

CREATE TABLE SurveyPaei (
  surveyPaeiId   INT(11)     NOT NULL AUTO_INCREMENT,
  userId         VARCHAR(20) NOT NULL,
  submissionTime TIMESTAMP   NULL,
  q1             SMALLINT(6),
  q2             SMALLINT(6),
  q3             SMALLINT(6),
  q4             SMALLINT(6),
  q5             SMALLINT(6),
  q6             SMALLINT(6),
  q7             SMALLINT(6),
  q8             SMALLINT(6),
  q9             SMALLINT(6),
  q10            SMALLINT(6),
  q11            SMALLINT(6),
  q12            SMALLINT(6),
  q13            SMALLINT(6),
  q14            SMALLINT(6),
  q15            SMALLINT(6),
  q16            SMALLINT(6),
  q17            SMALLINT(6),
  q18            SMALLINT(6),
  q19            SMALLINT(6),
  q20            SMALLINT(6),
  q21            SMALLINT(6),
  q22            SMALLINT(6),
  q23            SMALLINT(6),
  q24            SMALLINT(6),
  q25            SMALLINT(6),
  q26            SMALLINT(6),
  q27            SMALLINT(6),
  producer       SMALLINT(6),
  administrator  SMALLINT(6),
  entrepreneur   SMALLINT(6),
  integrator     SMALLINT(6),
  PRIMARY KEY (surveyPaeiId)
);

CREATE TABLE Role (
  roleId   INT(11)     NOT NULL AUTO_INCREMENT,
  roleName VARCHAR(20) NOT NULL,
  PRIMARY KEY (roleId)
);

/*ALTER TABLE User DROP FOREIGN KEY FKUser635666;
ALTER TABLE SensorHeartbeat DROP FOREIGN KEY FKSensorHear374803;
ALTER TABLE SensorEmotion DROP FOREIGN KEY FKSensorEmot814851;
ALTER TABLE SensorSweat DROP FOREIGN KEY FKSensorSwea362588;
ALTER TABLE SensorAudio DROP FOREIGN KEY FKSensorAudi678893;
ALTER TABLE SurveyBelbin DROP FOREIGN KEY FKSurveyBelb267352;
ALTER TABLE SurveyMbti DROP FOREIGN KEY FKSurveyMbti125955;
ALTER TABLE SurveyVak DROP FOREIGN KEY FKSurveyVak493501;
ALTER TABLE SurveyPaei DROP FOREIGN KEY FKSurveyPaei38008;
*/
ALTER TABLE `User`
  ADD CONSTRAINT FKUser635666 FOREIGN KEY (roleId) REFERENCES Role (roleId);
ALTER TABLE SensorHeartbeat
  ADD CONSTRAINT FKSensorHear374803 FOREIGN KEY (userId) REFERENCES `User` (userId);
ALTER TABLE SensorEmotion
  ADD CONSTRAINT FKSensorEmot814851 FOREIGN KEY (userId) REFERENCES `User` (userId);
ALTER TABLE SensorSweat
  ADD CONSTRAINT FKSensorSwea362588 FOREIGN KEY (userId) REFERENCES `User` (userId);
ALTER TABLE SensorAudio
  ADD CONSTRAINT FKSensorAudi678893 FOREIGN KEY (userId) REFERENCES `User` (userId);
ALTER TABLE SurveyBelbin
  ADD CONSTRAINT FKSurveyBelb267352 FOREIGN KEY (userId) REFERENCES `User` (userId);
ALTER TABLE SurveyMbti
  ADD CONSTRAINT FKSurveyMbti125955 FOREIGN KEY (userId) REFERENCES `User` (userId);
ALTER TABLE SurveyVak
  ADD CONSTRAINT FKSurveyVak493501 FOREIGN KEY (userId) REFERENCES `User` (userId);
ALTER TABLE SurveyPaei
  ADD CONSTRAINT FKSurveyPaei38008 FOREIGN KEY (userId) REFERENCES `User` (userId);
