/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : soccersys

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 05/05/2021 11:23:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for coach
-- ----------------------------
DROP TABLE IF EXISTS `coach`;
CREATE TABLE `coach`  (
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `isFullTime` int(11) NULL DEFAULT NULL,
  `coachID` int(11) NOT NULL AUTO_INCREMENT,
  `coachName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`coachID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach
-- ----------------------------
INSERT INTO `coach` VALUES ('klopp', '欧足联A级', 1, 1, '克洛普');
INSERT INTO `coach` VALUES ('pep2012', '欧足联A级', 1, 2, '瓜迪奥拉');
INSERT INTO `coach` VALUES ('ance111', '欧足联A级', 0, 3, '安切洛蒂');
INSERT INTO `coach` VALUES ('favre', '欧足联A级', 1, 4, '法弗尔');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `courseID` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courseGrade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `coachName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `coachUserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`courseID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '足球启蒙课', '幼儿', '克洛普', '每周五下午两点', '开启足球第一课', 'klopp');
INSERT INTO `course` VALUES (2, '传控进阶', '职业', '安切洛蒂', '每周五下午两点', '来自皇家马德里的内部课程', 'ance111');
INSERT INTO `course` VALUES (6, '足球启蒙课', '职业', '安切洛蒂', '每周五下午两点', '好啊好好好', 'ance111');

-- ----------------------------
-- Table structure for courseinf
-- ----------------------------
DROP TABLE IF EXISTS `courseinf`;
CREATE TABLE `courseinf`  (
  `courseInfID` int(11) NOT NULL AUTO_INCREMENT,
  `courseID` int(11) NULL DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courseName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`courseInfID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courseinf
-- ----------------------------
INSERT INTO `courseinf` VALUES (1, 1, 'lgn', '足球启蒙课');

-- ----------------------------
-- Table structure for field
-- ----------------------------
DROP TABLE IF EXISTS `field`;
CREATE TABLE `field`  (
  `fieldID` int(11) NOT NULL AUTO_INCREMENT,
  `fieldName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `size` int(11) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  `hasLight` int(11) NULL DEFAULT NULL,
  `inDoor` int(11) NULL DEFAULT NULL,
  `realGrass` int(11) NULL DEFAULT NULL,
  `hasShop` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`fieldID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of field
-- ----------------------------
INSERT INTO `field` VALUES (12, '青城五人室内球场', '沪港西路44号', '条件很好，顶级球场', 5, 150.00, 1, 1, 1, 1);
INSERT INTO `field` VALUES (13, '青城七人室内球场', '沪港西路44号', '好啊好好好', 7, 200.00, 1, 1, 1, 1);
INSERT INTO `field` VALUES (14, '五四体育场', '和平区文化路三巷11号', '有看台 标准球场', 5, 2000.00, 1, 1, 0, 0);
INSERT INTO `field` VALUES (15, '五五体育场', '和平区文化路三巷11号', '沙土地', 11, 150.00, 1, 0, 0, 0);

-- ----------------------------
-- Table structure for fieldreserve
-- ----------------------------
DROP TABLE IF EXISTS `fieldreserve`;
CREATE TABLE `fieldreserve`  (
  `fieldOrderID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fieldName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`fieldOrderID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fieldreserve
-- ----------------------------
INSERT INTO `fieldreserve` VALUES (5, 'lgn', '2021-05-03', '五四体育场');
INSERT INTO `fieldreserve` VALUES (6, 'gngnggnn1', '2021-06-05', '五五体育场');

-- ----------------------------
-- Table structure for jointeamapplication
-- ----------------------------
DROP TABLE IF EXISTS `jointeamapplication`;
CREATE TABLE `jointeamapplication`  (
  `applyID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teamIDToJoin` int(11) NOT NULL,
  `passed` int(11) NULL DEFAULT NULL,
  `userRealName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`applyID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jointeamapplication
-- ----------------------------
INSERT INTO `jointeamapplication` VALUES (2, 'lgn', 24, 1, '但是');
INSERT INTO `jointeamapplication` VALUES (4, 'lgn', 24, 1, '大苏打的');
INSERT INTO `jointeamapplication` VALUES (5, 'gngnggnn1', 24, 1, '帅哥');

-- ----------------------------
-- Table structure for match
-- ----------------------------
DROP TABLE IF EXISTS `match`;
CREATE TABLE `match`  (
  `matchID` int(11) NOT NULL AUTO_INCREMENT,
  `matchDate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teamName1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teamName2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `hasPlayed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `score` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `matchDescription` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`matchID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of match
-- ----------------------------
INSERT INTO `match` VALUES (9, '2021-04-07', 'bvb', '辽宁宏运', '1', '3-2', '罗伊斯帽子戏法，肇俊哲梅开二度难救主');
INSERT INTO `match` VALUES (11, '2021-04-21', 'bvb', 'MU', '1', '3-2', '罗伊斯帽子戏法，肇俊哲梅开二度难救主');
INSERT INTO `match` VALUES (29, '2021-04-19', 'Dortmund', 'MU', '1', '1-1', '林皇传射，一助攻一乌龙支配比赛');
INSERT INTO `match` VALUES (31, '2021-05-31', 'Dortmund', '辽宁宏运', '1', '1-1', '哈兰德传射，一助攻一乌龙支配比赛');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `teamID` int(11) NOT NULL AUTO_INCREMENT,
  `teamName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `teamGrade` int(11) NULL DEFAULT NULL,
  `captainName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `contact` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`teamID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES (22, '辽宁宏运', 1, '肇俊哲', '0240000000', '好啊好好好');
INSERT INTO `team` VALUES (23, 'Dortmund', 1, 'Reus', '123000000', '老牌俱乐部');
INSERT INTO `team` VALUES (24, 'MU', 1, '林加德 ', '02400000002', '老牌俱乐部');

-- ----------------------------
-- Table structure for thread
-- ----------------------------
DROP TABLE IF EXISTS `thread`;
CREATE TABLE `thread`  (
  `threadID` int(11) NOT NULL AUTO_INCREMENT,
  `topic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `time` datetime(0) NULL DEFAULT NULL,
  `detail` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `threadGrade` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`threadID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thread
-- ----------------------------
INSERT INTO `thread` VALUES (2, '明天约球的兄弟有没有', 'lgn', '2021-04-27 15:48:22', '来五五体育场约球', 1);
INSERT INTO `thread` VALUES (4, '明天场地关闭', 'admin', '2021-04-28 11:16:30', '因为灯光升级，场地关闭', 1);
INSERT INTO `thread` VALUES (5, '坛友须知', 'admin', '2021-04-28 15:19:10', '请大家不要发表反动言论', 0);
INSERT INTO `thread` VALUES (6, '明天场地关闭', 'admin', '2021-04-30 17:10:37', '因为灯光升级，场地关闭', 0);
INSERT INTO `thread` VALUES (7, '明天踢球吗？', 'admin', '2021-04-30 17:10:59', '不见不散', 1);
INSERT INTO `thread` VALUES (8, '今天舒服啊', 'admin', '2021-04-30 17:12:57', '大胜!', 1);
INSERT INTO `thread` VALUES (9, '564564', 'admin', '2021-04-30 23:51:12', '好好说话', 0);
INSERT INTO `thread` VALUES (10, '明天来一场五人制？', 'lgn', '2021-05-03 14:17:21', '加我好友', 1);
INSERT INTO `thread` VALUES (11, '内部课程限量发布，快来抢', 'ance111', '2021-05-03 20:30:35', '认准我安切洛蒂', 1);
INSERT INTO `thread` VALUES (12, '多特蒙德招人了，明天来试训', 'bvb1909', '2021-05-03 20:44:40', '千载难逢，不要错过', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `identity` int(255) NOT NULL,
  `teamID` int(255) NULL DEFAULT NULL,
  `realName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`userName`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('admin', 'admin', 1, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('ance111', 'ance111', 4, NULL, '安切洛蒂', NULL, NULL, NULL);
INSERT INTO `user` VALUES ('bvb1909', 'bvb1909', 3, 23, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('favre', 'favre', 4, NULL, '法弗尔', NULL, NULL, NULL);
INSERT INTO `user` VALUES ('gngnggnn1', 'gngnggnn1', 2, 24, '帅哥', NULL, 26, '123456');
INSERT INTO `user` VALUES ('klopp', 'klopp', 4, NULL, '克洛普', NULL, NULL, NULL);
INSERT INTO `user` VALUES ('lgn', 'lgn', 2, 24, '5656', '男', 23, '123123');
INSERT INTO `user` VALUES ('liaoning', 'liaoning', 3, 22, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('mufc', 'mufc123', 3, 24, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES ('pep2012', 'pep2012', 4, NULL, '瓜迪奥拉', NULL, NULL, NULL);
INSERT INTO `user` VALUES ('swf', 'swf', 2, NULL, '455', NULL, 31, '1515151515151');

SET FOREIGN_KEY_CHECKS = 1;
