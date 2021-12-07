/*
 Navicat Premium Data Transfer

 Source Server         : fcl
 Source Server Type    : MySQL
 Source Server Version : 80016
 Source Host           : localhost:3306
 Source Schema         : hospital

 Target Server Type    : MySQL
 Target Server Version : 80016
 File Encoding         : 65001

 Date: 07/12/2021 20:13:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `account` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`account`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('admin', '123456');

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `author` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `releasedate` date NULL DEFAULT NULL,
  `isdel` int(2) UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `aua`(`author`) USING BTREE,
  CONSTRAINT `aua` FOREIGN KEY (`author`) REFERENCES `admin` (`account`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES (1, '艾哈达', '德国哈维嗲阿卜杜喀和第哦啊', 'admin', '2021-12-03', 0);
INSERT INTO `announcement` VALUES (2, '的尼可拉我电脑', '挨了打进来的我都把可恶的阿卜杜喀娇娃', 'admin', '2021-12-04', 0);

-- ----------------------------
-- Table structure for career
-- ----------------------------
DROP TABLE IF EXISTS `career`;
CREATE TABLE `career`  (
  `cid` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `cname` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of career
-- ----------------------------
INSERT INTO `career` VALUES (1, '医师');
INSERT INTO `career` VALUES (2, '主治医师');
INSERT INTO `career` VALUES (3, '副主任医师');
INSERT INTO `career` VALUES (4, '主任医师');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type` int(4) UNSIGNED NULL DEFAULT NULL,
  `location` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `des` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `isdel` int(4) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '神经内科', 0, '1号楼2楼', '主要以神经系统为主', 0);
INSERT INTO `department` VALUES (2, '呼吸内科', 0, '1号楼2楼', '呼吸系统为主', 0);
INSERT INTO `department` VALUES (3, '消化内科', 0, '1号楼3楼', '主要是消化系统', 0);
INSERT INTO `department` VALUES (4, '肾内科', 0, '2号楼2楼', '主要是泌尿系统', 0);
INSERT INTO `department` VALUES (5, '耳鼻喉科', 1, '1号楼3楼', '主要包括耳、鼻、喉部的手术', 0);
INSERT INTO `department` VALUES (6, '眼科', 1, '2号楼2楼', '现有眼视光学、眼科和视光学', 0);
INSERT INTO `department` VALUES (7, '普外科', 1, '1号楼3楼', '都可以收', 0);
INSERT INTO `department` VALUES (8, '骨科', 1, '2号楼3楼', '主要是全身骨骼', 0);
INSERT INTO `department` VALUES (9, '血液内科', 0, '2号楼3楼', '主要是血液系统', 0);
INSERT INTO `department` VALUES (10, '内分泌科', 0, '3号楼2楼', '主要是内分泌', 0);
INSERT INTO `department` VALUES (11, '传染内科', 0, '2号楼3楼', '主要是内分泌系统', 0);
INSERT INTO `department` VALUES (12, '肝胆外科', 1, '1号楼2楼', '主要是肝胆', 0);

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `did` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `account` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '123456',
  `dname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` int(2) UNSIGNED NULL DEFAULT NULL,
  `age` int(4) UNSIGNED NULL DEFAULT NULL,
  `fee` double(5, 2) UNSIGNED NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `imagepath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `career` int(11) UNSIGNED NULL DEFAULT NULL,
  `department` int(10) UNSIGNED NULL DEFAULT NULL,
  `register` int(3) UNSIGNED NULL DEFAULT NULL,
  `isdel` int(2) UNSIGNED NULL DEFAULT 0,
  PRIMARY KEY (`did`) USING BTREE,
  INDEX `cc`(`career`) USING BTREE,
  INDEX `dd`(`department`) USING BTREE,
  CONSTRAINT `cc` FOREIGN KEY (`career`) REFERENCES `career` (`cid`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `dd` FOREIGN KEY (`department`) REFERENCES `department` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES (1, '20211024801', 'fcl123', 'doctor1', 1, 70, 15.00, '感到骄傲和的感觉', '小雪.png', 3, 9, 0, 0);
INSERT INTO `doctor` VALUES (2, '20211021101', '123123', 'doctor2', 1, 70, 100.00, '加咖啡咖啡好卡', NULL, 3, 8, 1, 0);
INSERT INTO `doctor` VALUES (3, '20211023001', '123456', 'doctor3', 0, 68, 150.00, '等会我的发挥', NULL, 4, 10, 1, 0);
INSERT INTO `doctor` VALUES (4, '20211021001', '123456', 'doctor4', 1, 35, 15.00, '能否寇拉横幅', NULL, 2, 3, 0, 0);
INSERT INTO `doctor` VALUES (5, '20021024001', '123456', 'doctor5', 0, 75, 200.00, '卡号打卡大卡的话', '波克比.jpg', 4, 2, 1, 0);
INSERT INTO `doctor` VALUES (6, '20151021002', '123456', 'doctor6', 1, 40, 30.00, '啊空间的把控', NULL, 2, 12, 0, 0);
INSERT INTO `doctor` VALUES (7, '20151021003', '123456', 'doctor7', 0, 50, 15.00, '带你去我卡的很', NULL, 2, 5, 0, 0);
INSERT INTO `doctor` VALUES (8, '20121020801', '123456', 'doctor8', 1, 40, 15.00, '爱德华带哦觉得我', NULL, 1, 4, 0, 0);
INSERT INTO `doctor` VALUES (9, '20091020802', '123456', 'doctor9', 1, 40, 15.00, '卡号你嗲', NULL, 3, 6, 0, 0);
INSERT INTO `doctor` VALUES (10, '20081020601', '123456', 'doctor10', 0, 60, 100.00, '卡位很多覅开挖后', NULL, 3, 9, 1, 0);
INSERT INTO `doctor` VALUES (11, '20071020901', '123456', 'doctor11', 0, 70, 150.00, 'd打卡文化的卡', NULL, 4, 9, 1, 0);
INSERT INTO `doctor` VALUES (12, '20021021001', '123456', 'doctor12', 0, 50, 20.00, '爱德华那块我觉得很难卡机', '屏幕截图 2021-05-19 161759.jpg', 2, 4, 0, 0);

-- ----------------------------
-- Table structure for request
-- ----------------------------
DROP TABLE IF EXISTS `request`;
CREATE TABLE `request`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `did` int(10) UNSIGNED NULL DEFAULT NULL,
  `week` int(3) UNSIGNED NULL DEFAULT NULL,
  `time` int(3) UNSIGNED NULL DEFAULT NULL,
  `reason` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `state` int(3) UNSIGNED NULL DEFAULT 0,
  `subtime` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `ddid`(`did`) USING BTREE,
  CONSTRAINT `ddid` FOREIGN KEY (`did`) REFERENCES `doctor` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of request
-- ----------------------------
INSERT INTO `request` VALUES (1, 1, 4, 2, NULL, 2, '2021-12-05');
INSERT INTO `request` VALUES (2, 1, 2, 2, '的视频', 2, '2021-12-05');
INSERT INTO `request` VALUES (3, 6, 3, 1, '的粉色粉色', 1, '2021-12-06');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `tel` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `idcard` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `regtime` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'user1', '123456', '12345678911', '张三', '341203198010130534', '2021-12-03');
INSERT INTO `user` VALUES (2, 'user2', '123456', '13452653322', '李四', '341203198010130534', '2021-12-03');
INSERT INTO `user` VALUES (3, 'user3', '123456', '12345678911', '王五', '341203198010130534', '2021-12-03');

-- ----------------------------
-- Table structure for work
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `did` int(10) UNSIGNED NULL DEFAULT NULL,
  `week` int(3) UNSIGNED NULL DEFAULT NULL,
  `time` int(3) UNSIGNED NULL DEFAULT NULL,
  `number` int(4) UNSIGNED NULL DEFAULT NULL,
  `state` int(2) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `dw`(`did`) USING BTREE,
  CONSTRAINT `dw` FOREIGN KEY (`did`) REFERENCES `doctor` (`did`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of work
-- ----------------------------
INSERT INTO `work` VALUES (1, 1, 8, 3, NULL, 1);
INSERT INTO `work` VALUES (3, 2, 1, 1, 20, 2);
INSERT INTO `work` VALUES (4, 4, 8, 3, 20, 1);
INSERT INTO `work` VALUES (6, 7, 3, 2, 30, 1);
INSERT INTO `work` VALUES (7, 6, 3, 2, 20, 1);

SET FOREIGN_KEY_CHECKS = 1;
