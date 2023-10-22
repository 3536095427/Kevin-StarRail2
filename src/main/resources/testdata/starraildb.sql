/*
 Navicat Premium Data Transfer

 Source Server         : localhost80
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : starraildb

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 28/09/2023 16:12:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for station
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station`  (
  `id` int NOT NULL,
  `name` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of station
-- ----------------------------
INSERT INTO `station` VALUES (1, '乌鲁木齐');
INSERT INTO `station` VALUES (2, '西宁');
INSERT INTO `station` VALUES (3, '兰州');
INSERT INTO `station` VALUES (4, '呼和浩特');
INSERT INTO `station` VALUES (5, '北京');
INSERT INTO `station` VALUES (6, '天津');
INSERT INTO `station` VALUES (7, '沈阳');
INSERT INTO `station` VALUES (8, '长春');
INSERT INTO `station` VALUES (9, '哈尔滨');
INSERT INTO `station` VALUES (10, '大连');
INSERT INTO `station` VALUES (11, '西安');
INSERT INTO `station` VALUES (12, '郑州');
INSERT INTO `station` VALUES (13, '徐州');
INSERT INTO `station` VALUES (14, '成都');
INSERT INTO `station` VALUES (15, '武汉');
INSERT INTO `station` VALUES (16, '上海');
INSERT INTO `station` VALUES (17, '昆明');
INSERT INTO `station` VALUES (18, '贵阳');
INSERT INTO `station` VALUES (19, '株洲');
INSERT INTO `station` VALUES (20, '南昌');
INSERT INTO `station` VALUES (21, '福州');
INSERT INTO `station` VALUES (22, '南宁');
INSERT INTO `station` VALUES (23, '柳州');
INSERT INTO `station` VALUES (24, '广州');
INSERT INTO `station` VALUES (25, '深圳');

-- ----------------------------
-- Table structure for travel
-- ----------------------------
DROP TABLE IF EXISTS `travel`;
CREATE TABLE `travel`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `orgin` int NOT NULL,
  `destination` int NOT NULL,
  `distance` int NOT NULL,
  `money` int NOT NULL,
  `time` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `orgin`(`orgin` ASC) USING BTREE,
  INDEX `destination`(`destination` ASC) USING BTREE,
  CONSTRAINT `travel_ibfk_1` FOREIGN KEY (`orgin`) REFERENCES `station` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `travel_ibfk_2` FOREIGN KEY (`destination`) REFERENCES `station` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of travel
-- ----------------------------
INSERT INTO `travel` VALUES (11, 1, 3, 1892, 217, 1403);
INSERT INTO `travel` VALUES (12, 3, 2, 216, 32, 171);
INSERT INTO `travel` VALUES (13, 3, 4, 1145, 148, 1082);
INSERT INTO `travel` VALUES (14, 4, 5, 668, 86, 566);
INSERT INTO `travel` VALUES (15, 5, 6, 137, 19, 165);
INSERT INTO `travel` VALUES (16, 6, 7, 704, 93, 589);
INSERT INTO `travel` VALUES (17, 7, 8, 305, 46, 212);
INSERT INTO `travel` VALUES (18, 7, 10, 97, 53, 302);
INSERT INTO `travel` VALUES (19, 8, 9, 242, 37, 193);
INSERT INTO `travel` VALUES (20, 3, 11, 676, 93, 558);
INSERT INTO `travel` VALUES (21, 11, 12, 511, 72, 370);
INSERT INTO `travel` VALUES (22, 12, 13, 349, 51, 248);
INSERT INTO `travel` VALUES (23, 12, 5, 685, 93, 363);
INSERT INTO `travel` VALUES (24, 13, 6, 674, 93, 35);
INSERT INTO `travel` VALUES (26, 16, 20, 825, 105, 538);
INSERT INTO `travel` VALUES (27, 20, 21, 622, 75, 250);
INSERT INTO `travel` VALUES (28, 20, 19, 367, 53, 301);
INSERT INTO `travel` VALUES (29, 19, 24, 675, 102, 505);
INSERT INTO `travel` VALUES (30, 24, 25, 140, 67, 161);
INSERT INTO `travel` VALUES (31, 19, 23, 672, 86, 487);
INSERT INTO `travel` VALUES (32, 23, 22, 255, 40, 188);
INSERT INTO `travel` VALUES (33, 23, 18, 607, 86, 409);
INSERT INTO `travel` VALUES (34, 19, 18, 902, 115, 787);
INSERT INTO `travel` VALUES (35, 18, 17, 639, 86, 438);
INSERT INTO `travel` VALUES (36, 17, 14, 1100, 119, 569);
INSERT INTO `travel` VALUES (38, 14, 11, 842, 112, 1003);
INSERT INTO `travel` VALUES (39, 19, 15, 409, 62, 351);
INSERT INTO `travel` VALUES (40, 15, 12, 534, 75, 294);
INSERT INTO `travel` VALUES (41, 3, 1, 1892, 217, 1403);
INSERT INTO `travel` VALUES (42, 2, 3, 216, 32, 171);
INSERT INTO `travel` VALUES (43, 4, 3, 1145, 148, 1082);
INSERT INTO `travel` VALUES (44, 5, 4, 668, 86, 566);
INSERT INTO `travel` VALUES (45, 6, 5, 137, 19, 165);
INSERT INTO `travel` VALUES (46, 7, 6, 704, 93, 589);
INSERT INTO `travel` VALUES (47, 8, 7, 305, 46, 212);
INSERT INTO `travel` VALUES (48, 10, 7, 97, 53, 302);
INSERT INTO `travel` VALUES (49, 9, 8, 242, 37, 193);
INSERT INTO `travel` VALUES (50, 11, 3, 676, 93, 558);
INSERT INTO `travel` VALUES (51, 12, 11, 511, 72, 370);
INSERT INTO `travel` VALUES (52, 13, 12, 349, 51, 248);
INSERT INTO `travel` VALUES (53, 5, 12, 685, 93, 363);
INSERT INTO `travel` VALUES (54, 6, 13, 674, 93, 35);
INSERT INTO `travel` VALUES (56, 20, 16, 825, 105, 538);
INSERT INTO `travel` VALUES (57, 21, 20, 622, 75, 250);
INSERT INTO `travel` VALUES (58, 19, 20, 367, 53, 301);
INSERT INTO `travel` VALUES (59, 24, 19, 675, 102, 505);
INSERT INTO `travel` VALUES (60, 25, 24, 140, 67, 161);
INSERT INTO `travel` VALUES (61, 23, 19, 672, 86, 487);
INSERT INTO `travel` VALUES (62, 22, 23, 255, 40, 188);
INSERT INTO `travel` VALUES (63, 18, 23, 607, 86, 409);
INSERT INTO `travel` VALUES (64, 18, 19, 902, 115, 787);
INSERT INTO `travel` VALUES (65, 17, 18, 639, 86, 438);
INSERT INTO `travel` VALUES (66, 14, 17, 1100, 119, 569);
INSERT INTO `travel` VALUES (68, 11, 14, 842, 112, 1003);
INSERT INTO `travel` VALUES (69, 15, 19, 409, 62, 351);
INSERT INTO `travel` VALUES (70, 12, 15, 534, 75, 294);
INSERT INTO `travel` VALUES (71, 18, 14, 967, 91, 442);
INSERT INTO `travel` VALUES (72, 14, 18, 967, 91, 442);
INSERT INTO `travel` VALUES (73, 13, 16, 651, 91, 712);
INSERT INTO `travel` VALUES (74, 16, 13, 651, 91, 712);

-- ----------------------------
-- Table structure for user_basic
-- ----------------------------
DROP TABLE IF EXISTS `user_basic`;
CREATE TABLE `user_basic`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1035847 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_basic
-- ----------------------------
INSERT INTO `user_basic` VALUES (1035839, '三月七', '123');
INSERT INTO `user_basic` VALUES (1035840, '丹恒', '123');
INSERT INTO `user_basic` VALUES (1035841, '瓦尔特', '123');
INSERT INTO `user_basic` VALUES (1035842, '姬子', '123');
INSERT INTO `user_basic` VALUES (1035843, '卡芙卡', '78946');
INSERT INTO `user_basic` VALUES (1035845, '卢卡', '78946');
INSERT INTO `user_basic` VALUES (1035846, '刃', '78946');

-- ----------------------------
-- Table structure for user_detail
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `moto` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `adress` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `img` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  CONSTRAINT `user_detail_ibfk_1` FOREIGN KEY (`id`) REFERENCES `user_basic` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1035843 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_detail
-- ----------------------------
INSERT INTO `user_detail` VALUES (1035839, '三月七', '尝尝本姑娘的厉害！', '星穹列车', '1314520', '5.png');
INSERT INTO `user_detail` VALUES (1035840, '丹恒', '洞天幻化，长梦一觉', '罗浮仙舟', '5874135', '3.png');
INSERT INTO `user_detail` VALUES (1035841, '瓦尔特', '生存还是毁灭，你别无选择', '崩坏-逆熵', '211563', '2.png');
INSERT INTO `user_detail` VALUES (1035842, '姬子', '人类从不掩饰掌控星空的力量', '崩坏-休伯利安号', '79123162', '1.png');

SET FOREIGN_KEY_CHECKS = 1;
