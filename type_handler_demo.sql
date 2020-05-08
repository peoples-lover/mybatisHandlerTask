/*
 Navicat MySQL Data Transfer

 Source Server         : loacl_task
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : localhost:3306
 Source Schema         : mysql_task

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 08/05/2020 11:49:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for type_handler_demo
-- ----------------------------
DROP TABLE IF EXISTS `type_handler_demo`;
CREATE TABLE `type_handler_demo`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type_handler` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `is_delete` tinyint(4) NOT NULL DEFAULT 0 COMMENT '删除标识',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_modify` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'typeHandler测试' ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
