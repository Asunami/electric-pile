/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL5.7
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : localhost:3306
 Source Schema         : electric-pile

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 25/08/2023 16:34:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for consumption
-- ----------------------------
DROP TABLE IF EXISTS `consumption`;
CREATE TABLE `consumption`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '消费记录编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户编号',
  `order_id` int(11) NULL DEFAULT NULL COMMENT '订单编号',
  `money` decimal(10, 2) NULL DEFAULT NULL COMMENT '消费金额',
  `spend_time` datetime(0) NULL DEFAULT NULL COMMENT '消费时间',
  `creat_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '消费记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consumption
-- ----------------------------
INSERT INTO `consumption` VALUES (1, 1, 1, 46.20, '2023-05-18 10:58:18', '2023-05-18 10:58:18', NULL, 0);
INSERT INTO `consumption` VALUES (2, 2, 2, 39.50, '2023-05-18 12:34:33', '2023-05-18 12:34:33', NULL, 0);
INSERT INTO `consumption` VALUES (5, 1, 5, 79.00, '2023-05-26 18:09:20', '2023-05-26 18:09:20', '2023-05-26 18:09:20', 0);
INSERT INTO `consumption` VALUES (6, 3, 6, 90.48, '2023-06-06 21:24:51', '2023-06-06 21:24:51', '2023-06-06 21:24:51', 0);

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标名',
  `value` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标在element-ui中的值',
  `type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 图标类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES (1, '用户', 'el-icon-user-solid', 'icon');
INSERT INTO `dict` VALUES (2, '删除', 'el-icon-delete', 'icon');
INSERT INTO `dict` VALUES (3, '设置', 'el-icon-setting', 'icon');
INSERT INTO `dict` VALUES (4, '更多', 'el-icon-more', 'icon');
INSERT INTO `dict` VALUES (5, '帮助', 'el-icon-s-help', 'icon');
INSERT INTO `dict` VALUES (6, '警告', 'el-icon-warning', 'icon');
INSERT INTO `dict` VALUES (7, '订单', 'el-icon-s-order', 'icon');
INSERT INTO `dict` VALUES (8, '数据', 'el-icon-s-data', 'icon');
INSERT INTO `dict` VALUES (9, '审核', 'el-icon-s-check', 'icon');
INSERT INTO `dict` VALUES (10, '客户', 'el-icon-s-custom', 'icon');
INSERT INTO `dict` VALUES (11, '操作', 'el-icon-s-operation', 'icon');

-- ----------------------------
-- Table structure for evaluate
-- ----------------------------
DROP TABLE IF EXISTS `evaluate`;
CREATE TABLE `evaluate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户编号',
  `station_id` int(11) NULL DEFAULT NULL COMMENT '电站编号',
  `pile_id` int(11) NULL DEFAULT NULL COMMENT '电桩编号',
  `order_id` int(11) NULL DEFAULT NULL COMMENT '订单编号',
  `genre` int(1) NULL DEFAULT 1 COMMENT '评论类型',
  `score` int(3) NULL DEFAULT NULL COMMENT '评分',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `comment_time` datetime(0) NULL DEFAULT NULL COMMENT '评价时间',
  `creat_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of evaluate
-- ----------------------------
INSERT INTO `evaluate` VALUES (1, 1, 1, 2, 1, 1, 86, '一次不错的充电体验，环境很不错', NULL, '2023-05-18 11:06:12', '2023-05-18 11:06:12', NULL, 0);
INSERT INTO `evaluate` VALUES (2, 2, 3, 7, 2, 2, 89, '电桩充电速度很快，30分钟就充好了！', NULL, '2023-05-18 12:35:15', '2023-05-18 12:35:15', NULL, 0);
INSERT INTO `evaluate` VALUES (3, 3, 2, 5, 6, 2, 91, '一次不错的充电体验！好评', NULL, '2023-06-06 21:25:28', '2023-06-06 21:25:28', '2023-06-06 21:25:28', 0);

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `realname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实名字',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` int(1) NULL DEFAULT 1 COMMENT '状态',
  `remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员注册时输入的申请信息',
  `creat_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后台管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES (1, 'root', '$2a$10$7gAUDFxfKuSMxSd06Apn7.XCE.ep4WyqQLhG2FkPd8AyEg4/CyfS2', '张三', '18986755623', 'zhangsn@gmail.com', 0, 'pass', '2023-05-08 14:11:56', '2023-05-18 16:55:39', 0);
INSERT INTO `manager` VALUES (2, 'admin1', '$2a$10$7gAUDFxfKuSMxSd06Apn7.XCE.ep4WyqQLhG2FkPd8AyEg4/CyfS2', '李四', '16778976523', 'lisi@qq.com', 0, 'pass', '2023-05-08 14:12:36', '2023-05-18 16:42:54', 0);
INSERT INTO `manager` VALUES (3, 'admin2', '$2a$10$7gAUDFxfKuSMxSd06Apn7.XCE.ep4WyqQLhG2FkPd8AyEg4/CyfS2', '李五', '18876359826', 'liwu@goo.com', 0, 'pass', '2023-05-11 16:26:51', '2023-05-18 16:55:43', 0);
INSERT INTO `manager` VALUES (4, 'warn', '$2a$10$jjbRuYmyuG1Og8WPhR.OW.K4fubsGIFDrgyBW67glOMFM..vq4YyS', '王五', '17676438974', 'wangwu@cc.com', 0, 'pass', '2023-05-19 11:19:14', '2023-05-19 11:19:49', 0);
INSERT INTO `manager` VALUES (5, 'admin3', '$2a$10$WW0avngj9ENAywGPdtZ/LOrdgIQIXkruCAvhyp4msR7J83a8eFzFe', '陈六', '18556943654', 'chenliu@cc.com', 0, 'pass', '2023-06-06 21:28:20', '2023-06-06 21:28:44', 0);

-- ----------------------------
-- Table structure for manager_role
-- ----------------------------
DROP TABLE IF EXISTS `manager_role`;
CREATE TABLE `manager_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员-角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager_role
-- ----------------------------
INSERT INTO `manager_role` VALUES (1, 1, 1);
INSERT INTO `manager_role` VALUES (5, 2, 2);
INSERT INTO `manager_role` VALUES (7, 3, 2);
INSERT INTO `manager_role` VALUES (8, 4, 4);
INSERT INTO `manager_role` VALUES (9, 5, 2);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单编号',
  `pid` int(11) NULL DEFAULT NULL COMMENT '父级菜单id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名',
  `path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问路劲',
  `page_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '页面路径',
  `icon` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `sort` int(4) NULL DEFAULT NULL COMMENT '排序权重',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = 'rbac菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, NULL, '主页', '/home/home', 'home/index', 'el-icon-house', NULL, '主页');
INSERT INTO `menu` VALUES (2, NULL, '系统管理', NULL, '', 'el-icon-setting', NULL, '系统管理');
INSERT INTO `menu` VALUES (3, 2, '成员管理', '/system/manager', 'system/manager', 'el-icon-user-solid', NULL, '成员管理');
INSERT INTO `menu` VALUES (4, 2, '角色管理', '/system/role', 'system/role', 'el-icon-s-custom', NULL, '角色管理');
INSERT INTO `menu` VALUES (5, 2, '菜单管理', '/system/menu', 'system/menu', 'el-icon-s-help', NULL, '菜单管理');
INSERT INTO `menu` VALUES (6, 2, '注册审核', '/system/review', 'system/review', 'el-icon-s-check', NULL, '注册审核');
INSERT INTO `menu` VALUES (7, NULL, '用户管理', NULL, '', 'el-icon-user-solid', NULL, '用户管理');
INSERT INTO `menu` VALUES (8, 7, '用户列表', '/user/list', 'user/list', 'el-icon-s-custom', NULL, '用户列表');
INSERT INTO `menu` VALUES (9, NULL, '电站管理', NULL, '', 'el-icon-s-operation', NULL, '管理充电站');
INSERT INTO `menu` VALUES (10, 9, '电站列表', '/station/list', 'station/list', 'el-icon-s-data', NULL, '电站列表');
INSERT INTO `menu` VALUES (11, NULL, '充电桩管理', NULL, NULL, 'el-icon-s-operation', NULL, '管理充电桩');
INSERT INTO `menu` VALUES (12, 11, '充电桩列表', '/pile/list', 'pile/list', 'el-icon-s-data', NULL, '电桩列表');
INSERT INTO `menu` VALUES (13, 9, '电站评价', '/station/evaluate', 'station/evaluate', 'el-icon-more', NULL, '电站评价管理');
INSERT INTO `menu` VALUES (14, 11, '充电桩评价', '/pile/evaluate', 'pile/evaluate', 'el-icon-more', NULL, '充电桩评价管理');
INSERT INTO `menu` VALUES (16, 7, '充值记录', '/user/recharge', 'user/recharge', 'el-icon-more', NULL, '用户充值记录管理');
INSERT INTO `menu` VALUES (17, 11, '告警信息', '/pile/warn', 'pile/warn', 'el-icon-warning', NULL, '管理告警信息');
INSERT INTO `menu` VALUES (18, NULL, '订单管理', '/order/order', 'order/index', 'el-icon-s-order', NULL, '管理订单');
INSERT INTO `menu` VALUES (19, 7, '消费记录', '/user/consumption', 'user/consumption', 'el-icon-more', NULL, '所有用户的消费记录');
INSERT INTO `menu` VALUES (20, 7, '评价记录', '/user/evaluate', 'user/evaluate', 'el-icon-more', NULL, '所有用户的评价记录');
INSERT INTO `menu` VALUES (21, 11, '预约记录', '/pile/reservation', 'pile/reservation', 'el-icon-s-help', NULL, '充电桩的预约记录');

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `reservation_id` int(11) NULL DEFAULT NULL COMMENT '预约记录编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户编号',
  `pile_id` int(11) NULL DEFAULT NULL COMMENT '电桩编号',
  `status` int(1) NULL DEFAULT 1 COMMENT '订单状态(1未支付，2已支付，3已评价)',
  `money` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单金额',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '充电开始时间',
  `over_time` datetime(0) NULL DEFAULT NULL COMMENT '充电结束时间',
  `creat_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES (1, 1, 1, 2, 3, 46.20, '2023-05-18 10:30:13', '2023-05-18 10:58:18', '2023-05-18 10:58:18', '2023-05-18 20:45:34', 0);
INSERT INTO `order_item` VALUES (2, 5, 2, 7, 3, 39.50, '2023-05-18 12:03:33', '2023-05-18 12:34:33', '2023-05-18 12:34:33', '2023-05-18 20:45:36', 0);
INSERT INTO `order_item` VALUES (3, 7, 1, 1, 2, 76.37, '2023-05-18 15:25:32', '2023-05-18 16:23:36', '2023-05-18 16:23:36', '2023-05-26 17:02:30', 0);
INSERT INTO `order_item` VALUES (5, 9, 1, 1, 2, 79.00, '2023-05-26 17:08:24', '2023-05-26 18:09:12', '2023-05-26 18:09:12', '2023-05-26 18:09:20', 0);
INSERT INTO `order_item` VALUES (6, 10, 3, 5, 3, 90.48, '2023-06-06 20:23:20', '2023-06-06 21:24:38', '2023-06-06 21:24:38', '2023-06-06 21:25:28', 0);

-- ----------------------------
-- Table structure for pile
-- ----------------------------
DROP TABLE IF EXISTS `pile`;
CREATE TABLE `pile`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '充电桩编号',
  `station_id` int(11) NULL DEFAULT NULL COMMENT '电站编号',
  `longitude` decimal(10, 6) NULL DEFAULT NULL COMMENT '经度',
  `latitude` decimal(10, 6) NULL DEFAULT NULL COMMENT '纬度',
  `status` int(1) NULL DEFAULT 1 COMMENT '状态1空闲，2充电，3故障，4不可用',
  `price` decimal(5, 2) NULL DEFAULT NULL COMMENT '价格',
  `power` int(10) NULL DEFAULT NULL COMMENT '功率',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '充电桩图片',
  `information` varchar(127) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '信息',
  `creat_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '充电桩表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pile
-- ----------------------------
INSERT INTO `pile` VALUES (1, 1, NULL, NULL, 1, 79.00, 200, 'https://electric-pile.oss-cn-chengdu.aliyuncs.com/pile/images/pile1.jpg', '星星电站一号电桩', '2023-05-18 10:36:04', '2023-05-26 14:55:39', 0);
INSERT INTO `pile` VALUES (2, 1, NULL, NULL, 1, 99.00, 400, 'https://electric-pile.oss-cn-chengdu.aliyuncs.com/pile/images/pile2.jpg', '星星充电站二号电桩', '2023-05-18 10:36:42', '2023-05-26 14:55:44', 0);
INSERT INTO `pile` VALUES (3, 1, NULL, NULL, 1, 88.00, 299, 'https://electric-pile.oss-cn-chengdu.aliyuncs.com/pile/images/pile3.jpg', '星星充电站三号电桩', '2023-05-18 10:37:27', '2023-05-26 14:55:50', 0);
INSERT INTO `pile` VALUES (4, 2, NULL, NULL, 3, 79.00, 200, NULL, '特来电充电站一号电桩', '2023-05-18 10:36:04', '2023-05-26 14:33:46', 0);
INSERT INTO `pile` VALUES (5, 2, NULL, NULL, 1, 89.00, 360, NULL, '特来电充电站二号电桩', '2023-05-18 10:40:59', '2023-05-26 14:33:46', 0);
INSERT INTO `pile` VALUES (6, 2, NULL, NULL, 1, 120.00, 500, NULL, '特来电充电站三号电桩', '2023-05-18 10:41:30', '2023-05-26 14:33:46', 0);
INSERT INTO `pile` VALUES (7, 3, NULL, NULL, 1, 79.00, 200, NULL, '久长星星充电桩一号电桩', '2023-05-18 10:36:04', '2023-05-26 18:13:32', 0);
INSERT INTO `pile` VALUES (8, 3, NULL, NULL, 1, 99.00, 400, NULL, '久长星星充电桩二号电桩', '2023-05-18 10:36:42', '2023-05-26 18:13:32', 0);
INSERT INTO `pile` VALUES (9, 3, NULL, NULL, 1, 88.00, 299, NULL, '久长星星充电桩三号电桩', '2023-05-18 10:37:27', '2023-05-26 18:13:32', 0);
INSERT INTO `pile` VALUES (10, 4, NULL, NULL, 1, 79.00, 200, NULL, '恒多多充电站一号电桩', '2023-05-18 10:36:04', '2023-06-06 21:30:03', 0);
INSERT INTO `pile` VALUES (11, 4, NULL, NULL, 1, 89.00, 360, NULL, '恒多多充电站二号电桩', '2023-05-18 10:40:59', '2023-06-06 21:30:03', 0);
INSERT INTO `pile` VALUES (12, 4, NULL, NULL, 1, 120.00, 500, NULL, '恒多多充电站三号电桩', '2023-05-18 10:41:30', '2023-06-06 21:30:03', 0);
INSERT INTO `pile` VALUES (13, 5, NULL, NULL, 4, 79.00, 200, NULL, '玖能行充电站一号电桩', '2023-05-18 10:36:04', '2023-05-26 14:52:12', 0);
INSERT INTO `pile` VALUES (14, 5, NULL, NULL, 4, 89.00, 360, NULL, '玖能行充电站二号电桩', '2023-05-18 10:40:59', '2023-05-26 14:52:12', 0);
INSERT INTO `pile` VALUES (15, 5, NULL, NULL, 4, 120.00, 500, NULL, '玖能行充电站三号电桩', '2023-05-18 10:41:30', '2023-05-26 14:52:12', 0);

-- ----------------------------
-- Table structure for recharge
-- ----------------------------
DROP TABLE IF EXISTS `recharge`;
CREATE TABLE `recharge`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '充值编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户编号',
  `alipay_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付订单号',
  `money` decimal(10, 2) NULL DEFAULT NULL COMMENT '充值金额',
  `status` int(1) NULL DEFAULT NULL COMMENT '充值状态',
  `charge_time` datetime(0) NULL DEFAULT NULL COMMENT '充值时间',
  `creat_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '充值记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of recharge
-- ----------------------------
INSERT INTO `recharge` VALUES (1, 1, '2023051822001431280506842344', 2000.00, 2, '2023-05-18 10:51:30', '2023-05-17 21:22:04', NULL, 0);
INSERT INTO `recharge` VALUES (4, 2, '2023051822001431280506841847', 2000.00, 2, '2023-05-18 11:14:27', '2023-05-17 21:22:13', NULL, 0);
INSERT INTO `recharge` VALUES (21, 1, '2023052622001431280506846780', 500.00, 2, '2023-05-26 18:06:23', '2023-05-26 18:05:52', '2023-05-26 18:06:23', 0);
INSERT INTO `recharge` VALUES (36, 3, '2023060622001431280506851777', 2000.00, 2, '2023-06-06 21:19:05', '2023-06-06 21:18:23', '2023-06-06 21:19:05', 0);
INSERT INTO `recharge` VALUES (37, 3, '1689753260', 200.00, 2, '2023-07-19 15:54:21', '2023-07-19 15:54:18', '2023-07-19 15:54:21', 0);
INSERT INTO `recharge` VALUES (38, 3, '1689753275', 1000.00, 2, '2023-07-19 15:54:36', '2023-07-19 15:54:33', '2023-07-19 15:54:36', 0);

-- ----------------------------
-- Table structure for reservation
-- ----------------------------
DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '预约编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户编号',
  `pile_id` int(11) NULL DEFAULT NULL COMMENT '充电桩编号',
  `status` int(1) NULL DEFAULT 1 COMMENT '状态',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '预约开始时间',
  `over_time` datetime(0) NULL DEFAULT NULL COMMENT '预约结束时间',
  `creat_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '预约表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reservation
-- ----------------------------
INSERT INTO `reservation` VALUES (1, 1, 2, 3, '2023-05-18 10:30:13', '2023-05-18 10:58:18', '2023-05-18 10:58:18', NULL, 0);
INSERT INTO `reservation` VALUES (5, 2, 7, 3, '2023-05-18 12:03:33', '2023-05-18 12:34:33', '2023-05-18 12:34:33', NULL, 0);
INSERT INTO `reservation` VALUES (7, 1, 1, 3, '2023-05-18 15:25:32', '2023-05-18 16:23:36', '2023-05-18 16:23:36', NULL, 0);
INSERT INTO `reservation` VALUES (9, 1, 1, 3, '2023-05-26 17:08:24', '2023-05-26 18:09:12', '2023-05-26 18:08:01', '2023-05-26 18:09:12', 0);
INSERT INTO `reservation` VALUES (10, 3, 5, 3, '2023-06-06 20:23:20', '2023-06-06 21:24:38', '2023-06-06 21:21:12', '2023-06-06 21:24:38', 0);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `flag` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色标识',
  `name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'superAdmin', '超级管理员', '超级管理员');
INSERT INTO `role` VALUES (2, 'stationAdmin', '电站管理员', '电站管理员');
INSERT INTO `role` VALUES (3, 'orderAdmin', '订单管理员', '管理订单');
INSERT INTO `role` VALUES (4, 'warnHandle', '告警处理人员', '处理电桩的告警');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `menu_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 229 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色-权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (28, 3, 18);
INSERT INTO `role_menu` VALUES (185, 1, 1);
INSERT INTO `role_menu` VALUES (186, 1, 2);
INSERT INTO `role_menu` VALUES (187, 1, 3);
INSERT INTO `role_menu` VALUES (188, 1, 4);
INSERT INTO `role_menu` VALUES (189, 1, 5);
INSERT INTO `role_menu` VALUES (190, 1, 6);
INSERT INTO `role_menu` VALUES (191, 1, 7);
INSERT INTO `role_menu` VALUES (192, 1, 8);
INSERT INTO `role_menu` VALUES (193, 1, 16);
INSERT INTO `role_menu` VALUES (194, 1, 19);
INSERT INTO `role_menu` VALUES (195, 1, 20);
INSERT INTO `role_menu` VALUES (196, 1, 9);
INSERT INTO `role_menu` VALUES (197, 1, 10);
INSERT INTO `role_menu` VALUES (198, 1, 13);
INSERT INTO `role_menu` VALUES (199, 1, 11);
INSERT INTO `role_menu` VALUES (200, 1, 12);
INSERT INTO `role_menu` VALUES (201, 1, 14);
INSERT INTO `role_menu` VALUES (202, 1, 15);
INSERT INTO `role_menu` VALUES (203, 1, 17);
INSERT INTO `role_menu` VALUES (204, 1, 21);
INSERT INTO `role_menu` VALUES (205, 1, 18);
INSERT INTO `role_menu` VALUES (216, 4, 12);
INSERT INTO `role_menu` VALUES (217, 4, 17);
INSERT INTO `role_menu` VALUES (218, 4, 11);
INSERT INTO `role_menu` VALUES (219, 2, 1);
INSERT INTO `role_menu` VALUES (220, 2, 9);
INSERT INTO `role_menu` VALUES (221, 2, 10);
INSERT INTO `role_menu` VALUES (222, 2, 13);
INSERT INTO `role_menu` VALUES (223, 2, 11);
INSERT INTO `role_menu` VALUES (224, 2, 12);
INSERT INTO `role_menu` VALUES (225, 2, 14);
INSERT INTO `role_menu` VALUES (226, 2, 17);
INSERT INTO `role_menu` VALUES (227, 2, 21);
INSERT INTO `role_menu` VALUES (228, 2, 18);

-- ----------------------------
-- Table structure for station
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '电站编号',
  `manager_id` int(11) NULL DEFAULT NULL COMMENT '管理员编号',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电站名字',
  `address` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `longitude` decimal(10, 6) NULL DEFAULT NULL COMMENT '经度',
  `latitude` decimal(10, 6) NULL DEFAULT NULL COMMENT '纬度',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `status` int(1) NULL DEFAULT 1 COMMENT '状态1营业中，2休息中，3已停业',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `distance` double(8, 2) NULL DEFAULT NULL COMMENT '用来存储电站离查询者距离',
  `creat_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '电站表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of station
-- ----------------------------
INSERT INTO `station` VALUES (1, 2, '星星充电站', '贵阳市花溪区花溪公园花石路口站', 106.667034, 26.435210, '16778976523', 'https://electric-pile.oss-cn-chengdu.aliyuncs.com/pile/images/station1.jpg', 1, '星星充电站，为您持续服务', NULL, '2023-05-11 16:22:53', '2023-05-26 14:33:39', 0);
INSERT INTO `station` VALUES (2, 3, '特来电充电站', '贵阳市花溪区田园北路班芙小镇北侧', 106.669224, 26.428157, '18876359826', 'https://electric-pile.oss-cn-chengdu.aliyuncs.com/pile/images/station2.jpg', 1, '充电就来特来电', NULL, '2023-05-11 16:27:26', '2023-05-26 14:33:46', 0);
INSERT INTO `station` VALUES (3, 2, '久长星星充电桩', '贵阳市修文县兰海高速久长服务区', 106.599797, 26.839237, '17738266734', 'https://electric-pile.oss-cn-chengdu.aliyuncs.com/pile/images/station3.jpg', 1, '久长星星，久久长长', NULL, '2023-05-18 11:01:28', '2023-05-26 18:13:32', 0);
INSERT INTO `station` VALUES (4, 2, '恒多多充电站', '贵州省贵阳市花溪区思孟路', 106.625431, 26.400331, '18873849872', 'https://electric-pile.oss-cn-chengdu.aliyuncs.com/pile/images/station4.jpg', 1, '恒多多充电站欢迎您的光临', NULL, '2023-05-18 11:01:31', '2023-06-06 21:30:03', 0);
INSERT INTO `station` VALUES (5, 3, '玖能行充电站', '世纪梦美大酒店(贵阳花溪汽贸城店)东50米', 106.747865, 26.409521, '18876359826', 'https://electric-pile.oss-cn-chengdu.aliyuncs.com/pile/images/station5.jpg', 2, '玖能行智慧快充', NULL, '2023-05-19 18:05:49', '2023-05-26 14:52:12', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `nickname` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `phone` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `balance` decimal(10, 2) NULL DEFAULT NULL COMMENT '余额',
  `battery` int(3) NULL DEFAULT NULL COMMENT '车辆电量',
  `status` int(1) NULL DEFAULT 1 COMMENT '状态(0禁用，1离线，2在线）',
  `creat_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `is_delete` tinyint(1) NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '前台用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'asunami', '$2a$10$7gAUDFxfKuSMxSd06Apn7.XCE.ep4WyqQLhG2FkPd8AyEg4/CyfS2', '艾森纳米', 'https://electric-pile.oss-cn-chengdu.aliyuncs.com/pile/images/avator1.jpg', '18778366537', 2139.11, 88, 1, '2023-05-11 12:13:07', '2023-06-04 23:06:37', 0);
INSERT INTO `user` VALUES (2, 'derta', '$2a$10$7gAUDFxfKuSMxSd06Apn7.XCE.ep4WyqQLhG2FkPd8AyEg4/CyfS2', '德尔塔', '', '17626378978', 1960.50, 66, 1, '2023-05-14 11:12:48', '2023-07-19 15:56:59', 0);
INSERT INTO `user` VALUES (3, 'zelda', '$2a$10$5AEYyXPgKiNFnQ0sLcwEc.J.fl3k.DVNY6Hzty/C9qmkE08oIsuLm', '塞尔达', 'https://electric-pile.oss-cn-chengdu.aliyuncs.com/pile/images/avatar2.jpg', '18789876347', 3109.52, NULL, 2, '2023-06-06 21:17:54', '2023-07-19 16:20:27', 0);

-- ----------------------------
-- Table structure for warn
-- ----------------------------
DROP TABLE IF EXISTS `warn`;
CREATE TABLE `warn`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '告警记录编号',
  `pile_id` int(11) NULL DEFAULT NULL COMMENT '电桩编号',
  `warn_type` int(1) NULL DEFAULT NULL COMMENT '告警类型',
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '告警内容',
  `warn_time` datetime(0) NULL DEFAULT NULL COMMENT '告警时间',
  `status` int(1) NULL DEFAULT 1 COMMENT '告警状态',
  `creat_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `is_delete` tinyint(1) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '告警记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of warn
-- ----------------------------
INSERT INTO `warn` VALUES (1, 4, 1, '此充电桩发生了系统故障，正在紧急修复中', '2023-05-17 12:06:00', 2, '2023-05-19 19:42:24', '2023-05-19 19:42:24', 0);
INSERT INTO `warn` VALUES (2, 9, 3, '这个充电桩发生了未知的故障，维修人员正在想办法解决', '2023-05-17 14:09:09', 2, '2023-05-19 19:43:30', '2023-05-19 19:43:30', 0);
INSERT INTO `warn` VALUES (3, 10, 2, '此电桩的内部电路发生损坏', '2023-05-14 06:14:07', 3, '2023-05-19 19:44:13', '2023-05-19 19:44:13', 0);

SET FOREIGN_KEY_CHECKS = 1;
