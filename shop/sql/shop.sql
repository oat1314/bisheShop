/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3308
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2020-03-25 01:36:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `add_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '地址id',
  `cust_id` int(11) DEFAULT NULL COMMENT '客户id',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机号',
  `province` varchar(255) DEFAULT NULL COMMENT '省份',
  `city` varchar(255) DEFAULT NULL COMMENT '城市',
  `district` varchar(255) DEFAULT NULL COMMENT '区/县',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `consignee` varchar(255) DEFAULT NULL COMMENT '收件人',
  `flag` varchar(255) DEFAULT '1',
  `extend2` varchar(255) DEFAULT NULL,
  `extend3` varchar(255) DEFAULT NULL,
  `status` int(255) DEFAULT '0' COMMENT '(0是不默认地址，1是默认地址)',
  PRIMARY KEY (`add_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='地址表';

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('23', '13', '123123123', '河南省', '南阳市', '宛城区', '请问', 'ikun', '1', null, null, null);
INSERT INTO `address` VALUES ('24', '1', '13824801598', '湖北省', '南阳市', '洪山区', '123', '欧国鑫', '1', null, null, null);
INSERT INTO `address` VALUES ('25', '2', '123445678', '广东省', '广州1', '从化1', 'a1', '欧国鑫', '1', null, null, '0');
INSERT INTO `address` VALUES ('26', '2', '13824801598', '湖北省', '武汉市', '洪山区', '`', '欧国鑫', '0', null, null, null);
INSERT INTO `address` VALUES ('27', '2', '1238456123123', '湖北省', '武汉市', '洪山区', 'a', 'a', '0', null, null, null);
INSERT INTO `address` VALUES ('28', '2', '23', '湖北省', '武汉市', '洪山区', 'a', 'a', '0', null, null, null);
INSERT INTO `address` VALUES ('29', '2', '13821811546', '广东省', '广州', '从化', 'a', '欧国鑫', '1', null, null, '0');
INSERT INTO `address` VALUES ('30', '2', '13824801598', '广东省', '广州', '从化', 'aaa', 'iverson', '0', null, null, '0');
INSERT INTO `address` VALUES ('31', '2', '13824801598', '广东省', '广州', '从化', 'aaaa', 'iverson', '1', null, null, '1');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏夹id',
  `cust_id` int(11) DEFAULT NULL COMMENT '顾客id',
  `prod_id` int(11) DEFAULT NULL COMMENT '商品id',
  `flag` varchar(255) DEFAULT '1' COMMENT '1存在 0删除',
  `extend2` varchar(255) DEFAULT NULL,
  `extend3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品收藏表';

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('1', '2', '17', '1', null, null);
INSERT INTO `collect` VALUES ('2', '2', '6', '0', null, null);
INSERT INTO `collect` VALUES ('3', '2', '6', '1', null, null);

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `sup_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '生产厂家编号',
  `sup_name` char(30) DEFAULT NULL COMMENT '生产厂家名',
  `flag` varchar(255) DEFAULT '1',
  `extend2` varchar(255) DEFAULT NULL,
  `extend3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sup_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='生产厂家表(现是营销活动表)';

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '热销', '1', null, null);
INSERT INTO `company` VALUES ('2', '今日推荐', '1', null, null);
INSERT INTO `company` VALUES ('3', '超值', '1', null, null);
INSERT INTO `company` VALUES ('4', '优惠', '1', null, null);

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cust_id` int(6) NOT NULL AUTO_INCREMENT COMMENT '注册号(id)',
  `cust_code` char(255) CHARACTER SET cp1256 DEFAULT NULL COMMENT '客户密码',
  `email` varchar(255) DEFAULT NULL COMMENT '客户邮箱',
  `regis_date` datetime DEFAULT NULL COMMENT '客户注册时间',
  `zip` char(255) DEFAULT NULL COMMENT '邮编',
  `tel_no` char(11) DEFAULT NULL COMMENT '电话',
  `sex` char(2) DEFAULT '3' COMMENT '性别(1.男2女3秘密,默认3)',
  `cust_name` char(255) DEFAULT NULL COMMENT '账号',
  `cust_level` char(8) DEFAULT '0' COMMENT '客户等级',
  `cust_sco` int(11) DEFAULT NULL COMMENT '客户积分',
  `username` varchar(255) DEFAULT NULL COMMENT '昵称',
  `createtime` datetime DEFAULT NULL COMMENT '注册时间',
  `extend3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cust_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='客户表';

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('2', '25b6cf46e59f83bba6f1809448fb828c', null, null, null, null, '0', '403963470@qq.com', '0', null, '123456', null, null);
INSERT INTO `customer` VALUES ('3', '27bd81bb82ee3eb01ba84ad25f4412ae', null, null, null, null, '3', '164144967@qq.com', '0', null, '164144967@qq.com', null, null);

-- ----------------------------
-- Table structure for delivery
-- ----------------------------
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery` (
  `deliv_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '配送单编号',
  `cust_id` int(11) DEFAULT NULL COMMENT '客户id',
  `order_no` varchar(255) DEFAULT NULL COMMENT '订单编号',
  `prod_id` int(11) DEFAULT NULL COMMENT '商品编号',
  `qty` int(11) DEFAULT NULL COMMENT '商品数量',
  `unit_price` decimal(7,2) DEFAULT NULL COMMENT '商品单价',
  `tot_amt` decimal(9,2) DEFAULT NULL COMMENT '订单总额',
  `zip` char(6) DEFAULT NULL COMMENT '邮编',
  `addr` char(40) DEFAULT NULL COMMENT '地址',
  `tel_no` char(11) DEFAULT NULL COMMENT '电话',
  `deliv_date` datetime DEFAULT NULL COMMENT '配送日期',
  `cust_name` char(8) DEFAULT NULL COMMENT '客户姓名',
  `extend1` varchar(255) DEFAULT NULL,
  `extend2` varchar(255) DEFAULT NULL,
  `extend3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`deliv_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品配送单表';

-- ----------------------------
-- Records of delivery
-- ----------------------------
INSERT INTO `delivery` VALUES ('1', '1', '202001110307071', null, null, null, '10.00', null, '24', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('2', '1', '202001110308121', null, null, null, '60.00', null, '24', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('3', '1', '202001111702001', null, null, null, '0.20', null, '24', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('4', '2', '202002130108072', null, null, null, '60.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('5', '2', '202002151735012', null, null, null, '40.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('6', '2', '202002151807492', null, null, null, '100.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('7', '2', '202002151809112', null, null, null, '40.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('8', '2', '202002151826382', null, null, null, '40.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('9', '2', '202002170252282', null, null, null, '100.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('10', '2', '202002170257462', null, null, null, '52.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('11', '2', '202002170302352', null, null, null, '20.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('12', '2', '202002170310002', null, null, null, '60.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('13', '2', '202002170313152', null, null, null, '20.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('14', '2', '202002170314522', null, null, null, '20.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('15', '2', '202002170316372', null, null, null, '20.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('16', '2', '202002170318152', null, null, null, '20.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('17', '2', '202002170444462', null, null, null, '20.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('18', '2', '202002170453452', null, null, null, '20.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('19', '2', '202002170511002', null, null, null, '20.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('20', '2', '202002170512232', null, null, null, '100.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('21', '2', '202002170555432', null, null, null, '20.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('22', '2', '202002170556342', null, null, null, '20.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('23', '2', '202002201832432', null, null, null, '10.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('24', '2', '202002201832102', null, null, null, '10.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('25', '2', '202002211816232', null, null, null, '10.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('26', '2', '202002232325502', null, null, null, '56.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('27', '2', '202002240341202', null, null, null, '10.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('28', '2', '202002240428522', null, null, null, '10.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('29', '2', '202002240433052', null, null, null, '10.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('30', '2', '202002240440212', null, null, null, '12.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('31', '2', '202002250455052', null, null, null, '56.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('32', '2', '202002250455402', null, null, null, '56.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('33', '2', '202002250536542', null, null, null, '30.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('34', '2', '202002260526412', null, null, null, '89.90', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('35', '2', '202003052343132', null, null, null, '20.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('36', '2', '202003060258462', null, null, null, '10.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('37', '2', '202003060327302', null, null, null, '65.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('38', '2', '202003061828132', null, null, null, '63.90', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('39', '2', '202003160356052', null, null, null, '88.00', null, '29', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('40', '2', '202003190411072', null, null, null, '100.00', null, '25', null, null, null, null, null, null);
INSERT INTO `delivery` VALUES ('41', '2', '202003231624252', null, null, null, '10.00', null, '29', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for discount
-- ----------------------------
DROP TABLE IF EXISTS `discount`;
CREATE TABLE `discount` (
  `cust_level` char(8) NOT NULL COMMENT '客户等级',
  `discount` decimal(7,2) NOT NULL COMMENT '优惠率',
  `sco_re` char(20) NOT NULL DEFAULT '0' COMMENT '积分要求',
  `extend1` varchar(255) DEFAULT NULL,
  `extend2` varchar(255) DEFAULT NULL,
  `extend3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cust_level`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='优惠表';

-- ----------------------------
-- Records of discount
-- ----------------------------

-- ----------------------------
-- Table structure for kind
-- ----------------------------
DROP TABLE IF EXISTS `kind`;
CREATE TABLE `kind` (
  `kind_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品类别编号',
  `kind_name` char(15) DEFAULT NULL COMMENT '商品类别名',
  `flag` varchar(255) DEFAULT '1',
  `extend2` varchar(255) DEFAULT NULL,
  `extend3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`kind_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品类别表';

-- ----------------------------
-- Records of kind
-- ----------------------------
INSERT INTO `kind` VALUES ('1', '水果', '1', null, null);
INSERT INTO `kind` VALUES ('2', '零食', '1', null, null);
INSERT INTO `kind` VALUES ('3', '小吃', '1', null, null);
INSERT INTO `kind` VALUES ('6', '主食', '1', null, null);
INSERT INTO `kind` VALUES ('7', '甜品', '1', null, null);
INSERT INTO `kind` VALUES ('8', '饮料', '1', null, null);

-- ----------------------------
-- Table structure for pinglun
-- ----------------------------
DROP TABLE IF EXISTS `pinglun`;
CREATE TABLE `pinglun` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pinglun` varchar(255) DEFAULT '',
  `pro_id` int(11) DEFAULT '0',
  `cust_id` int(6) DEFAULT NULL,
  `extend1` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `pro_id` (`pro_id`),
  CONSTRAINT `pinglun_ibfk_1` FOREIGN KEY (`pro_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pinglun
-- ----------------------------
INSERT INTO `pinglun` VALUES ('1', '苹果评论', '2', '2', null);
INSERT INTO `pinglun` VALUES ('2', '苹果评论1', '2', '2', null);
INSERT INTO `pinglun` VALUES ('4', '苹果评论2', '2', '2', null);
INSERT INTO `pinglun` VALUES ('5', '苹果评论3', '2', '2', null);
INSERT INTO `pinglun` VALUES ('6', '牛奶1', '17', '2', null);
INSERT INTO `pinglun` VALUES ('7', '牛奶2', '17', '2', null);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品编号',
  `name` char(100) DEFAULT NULL COMMENT '商品名称',
  `kind_no` char(6) DEFAULT NULL COMMENT '商品类别编号',
  `sup_no` char(6) DEFAULT NULL COMMENT '商品品牌编号',
  `status` int(4) DEFAULT '1' COMMENT '商品状态（1在售，2下架，3售空）默认在售',
  `is_hot` int(4) DEFAULT '4' COMMENT '营销方式(默认为正常销售0、1秒杀、2今日推荐、3超值)',
  `storage` int(11) DEFAULT NULL COMMENT '商品库存量(暂时未用)',
  `prod_desc` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `image` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `pro_date` datetime DEFAULT NULL COMMENT '商品生产日期',
  `keep_date` datetime DEFAULT NULL COMMENT '商品保质期',
  `unit_price` decimal(7,2) DEFAULT NULL COMMENT '商品单价',
  `supply` int(11) DEFAULT NULL COMMENT '库存量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `extend1` varchar(255) DEFAULT '' COMMENT '已使用',
  `extend2` varchar(255) DEFAULT NULL COMMENT '已使用',
  `extend3` varchar(255) DEFAULT '' COMMENT '已使用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品表';

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('2', '苹果', '1', '2', '1', '3', '200', '苹果', '/uploaded/1583434673995pingguo1.jpg', null, null, '10.00', '199', null, '2019-02-28 10:23:03', null, null, '');
INSERT INTO `product` VALUES ('3', '鲟鱼肠', '2', '3', '2', '2', '300', '鲟鱼肠', '/images/tj.png', null, null, '50.00', '298', null, '2019-02-28 10:23:10', null, null, '');
INSERT INTO `product` VALUES ('5', '千层饼', '6', '2', '1', '2', '1', '千层饼', '/images/3.jpg', null, null, '52.00', '1', null, '2019-02-28 10:23:23', null, null, '');
INSERT INTO `product` VALUES ('6', '龙眼', '3', '3', '1', '3', '111', '龙眼', '/images/2.jpg', null, null, '20.00', '94', null, '2019-02-28 10:23:23', null, null, '');
INSERT INTO `product` VALUES ('7', '橙子', '1', '3', '2', '3', '0', '橙子', '/images/5.jpg', null, null, '5.00', '0', null, '2019-02-28 10:23:24', null, null, '');
INSERT INTO `product` VALUES ('8', '武式千层饼', '6', '1', '2', '2', '0', '武式千层饼', '/images/3.jpg', null, null, '58.00', '0', null, '2019-02-28 10:23:24', null, null, '');
INSERT INTO `product` VALUES ('10', '荔枝', '1', '11', '1', '3', '321', '荔枝', '/uploaded/1583423789277lizhi.jpg', null, null, '10.00', '321', null, '2019-02-28 10:23:25', null, null, '');
INSERT INTO `product` VALUES ('16', '可可球', '2', '2', '1', '1', '100', '可可球', '/uploaded/1583422445783kekeqiu.jpg', '2019-03-06 20:05:21', '2019-03-04 20:05:48', '78.00', '100', '2019-03-04 20:06:25', '2019-03-04 20:05:19', null, null, '');
INSERT INTO `product` VALUES ('17', '牛奶', '8', '2', '1', '1', '100', '牛奶', '/uploaded/1583422304016niunai1.jpg', '2019-03-04 08:46:36', '2019-06-27 08:46:39', '65.00', '99', '2019-03-06 08:46:59', '2019-03-06 08:46:00', null, null, '');
INSERT INTO `product` VALUES ('18', '牛肉干', '2', '2', '1', '2', '100', '牛肉干', '/uploaded/1583422836374niurougan.jpg', '2019-03-05 10:55:00', '2019-03-22 10:55:05', '89.00', '100', '2019-03-06 10:55:12', '2019-03-06 10:54:43', null, null, '');
INSERT INTO `product` VALUES ('20', '菠萝', '1', '3', '1', '1', '100', '菠萝', '/uploaded/1583422089084boluo2.jpg', '2019-02-26 10:56:12', '2019-03-14 10:56:17', '15.00', '100', '2019-03-05 10:56:25', '2019-03-06 10:56:49', null, null, '');
INSERT INTO `product` VALUES ('21', '坚果', '2', '2', '1', '2', '100', '坚果', '/uploaded/155436428753801.jpg', null, null, '20.00', '100', null, '2019-03-06 11:58:02', null, null, '');
INSERT INTO `product` VALUES ('22', '板栗', '2', '1', '1', '2', '100', '板栗', '/images/tj1.png', null, null, '17.00', '100', null, '2019-03-06 11:59:09', null, null, '');
INSERT INTO `product` VALUES ('23', '巧克力', '3', '1', '1', '2', '100', '巧克力', '/images/tj2.png', null, null, '100.00', '94', null, '2019-03-06 12:00:03', null, null, '');
INSERT INTO `product` VALUES ('31', '桂圆', '3', '3', '1', '3', '100', '桂圆', '/images/4.jpg', null, null, '5.00', '100', null, '2019-03-06 13:29:29', null, null, '');
INSERT INTO `product` VALUES ('36', '燕麦', '6', '3', '1', '4', '100', '燕麦', '/uploaded/155592171112810.jpg', null, null, '75.00', '99', null, '2019-04-22 16:28:32', '', null, '');
INSERT INTO `product` VALUES ('37', '粘糕', '7', '1', '1', '2', '100', '粘糕', '/uploaded/1555922061083scoll1.png', null, null, '64.00', '100', null, '2019-04-22 16:34:22', '', null, '');
INSERT INTO `product` VALUES ('39', '牛肉干', '3', '1', '1', '1', '123', '牛肉干', '/uploaded/1583422225524niurougan.jpg', null, null, '56.00', '123', null, '2019-05-10 16:18:35', '', null, '');
INSERT INTO `product` VALUES ('40', '怡宝饮用纯净水矿泉水', '8', '5', '1', '2', '200', '4.5l*4支/箱 * 3箱 12支大包装整箱桶装', '/uploaded/1582665735221yibao.jpg', null, null, '89.90', '199', null, '2020-02-26 05:22:16', '', null, '');
INSERT INTO `product` VALUES ('41', '农夫山泉', '8', '7', '1', '3', '200', '饮用水550ml*24瓶弱碱天然优质饮用天然水', '/uploaded/1583489796851nongfu.png', null, null, '30.90', '200', null, '2020-02-26 05:24:16', '', null, '');
INSERT INTO `product` VALUES ('42', '百事可乐', '8', '6', '1', '2', '60', '330ml*24罐整箱易拉罐听装限定碳酸饮料网红汽水便携包邮', '/uploaded/1583489760417kele.jpg', null, null, '19.80', '60', null, '2020-02-26 05:25:35', '', null, '');
INSERT INTO `product` VALUES ('43', '怡宝1', '8', '5', '1', '3', '2', '怡宝1', '/uploaded/1582666966448yibao.jpg', null, null, '50.00', '2', null, '2020-02-26 05:42:53', '', null, '');
INSERT INTO `product` VALUES ('45', '怡1', '6', '2', '1', '2', '1', '怡1', '/uploaded/1582904891450boluo.jpg', null, null, '1.00', '1', null, '2020-02-28 23:48:21', '', null, '');
INSERT INTO `product` VALUES ('46', '鱼豆腐', '2', '8', '1', '3', '100', '盐津铺子鱼豆腐', '/uploaded/1583420589032yudoufu.jpg', null, null, '29.90', '100', null, '2020-03-05 23:03:51', '', null, '');
INSERT INTO `product` VALUES ('47', '零食大礼包', '2', '8', '1', '2', '100', '盐津铺子零食大礼包休闲食品小吃辣条豆干辣味鱼豆腐整箱', '/uploaded/1583420794272lingshidalibao.jpg', null, null, '38.90', '100', null, '2020-03-05 23:06:35', '', null, '');
INSERT INTO `product` VALUES ('48', '卫龙大礼包', '2', '9', '1', '4', '50', '卫龙大礼包辣条亲嘴烧豆干麻辣味整箱儿时小吃休闲美食网红零食品', '/uploaded/1583420954701weilongdalibao.jpg', null, null, '29.80', '50', null, '2020-03-05 23:09:15', '', null, '');
INSERT INTO `product` VALUES ('49', '红富士苹果', '1', '10', '1', '2', '50', '烟台红富士苹果水果新鲜吃货带箱10爱心十助农斤当季整箱山东栖霞', '/uploaded/1583434702028pingguo1.jpg', null, null, '24.80', '50', null, '2020-03-05 23:12:48', '', null, '');
INSERT INTO `product` VALUES ('50', '石榴', '1', '11', '1', '2', '20', '云南蒙自石榴水果新鲜包邮整箱大甜石榴10斤比突尼斯软籽石榴好', '/uploaded/1583421257563panshiliu.jpg', null, null, '34.80', '20', null, '2020-03-05 23:14:18', '', null, '');
INSERT INTO `product` VALUES ('51', '海南哈密瓜', '1', '11', '1', '4', '10', '海南哈密瓜网纹瓜香甜蜜瓜新鲜一箱水果整箱当季包邮10斤应季特产', '/uploaded/1583421349538hamigua.jpg', null, null, '39.90', '10', null, '2020-03-05 23:15:30', '', null, '');
INSERT INTO `product` VALUES ('55', '农夫山泉东方树叶乌龙茶', '8', '12', '1', '3', '20', '农夫山泉东方树叶乌龙茶', '/uploaded/1583490070585nofu2.png', null, null, '63.90', '20', null, '2020-03-06 18:21:12', '', null, '');
INSERT INTO `product` VALUES ('56', '农夫山泉东方树叶乌龙茶', '8', '12', '2', '1', '30', '农夫山泉东方树叶乌龙茶', '/uploaded/1583490111202nofu2.png', null, null, '63.90', '29', null, '2020-03-06 18:21:51', '', null, '');
INSERT INTO `product` VALUES ('57', '维他柠檬茶', '8', '14', '1', '3', '50', '维他柠檬茶', '/uploaded/1583490435079weita.jpg', null, null, '20.00', '50', null, '2020-03-06 18:27:15', '', null, '');
INSERT INTO `product` VALUES ('58', '农夫山泉100%NFC橙汁', '8', '7', '1', '2', '20', '农夫山泉100%NFC橙汁', '/uploaded/1583512003778chengzhi.jpg', null, null, '142.00', '20', null, '2020-03-07 00:26:45', '', null, '');
INSERT INTO `product` VALUES ('59', '现摘牛奶草莓', '1', '11', '1', '2', '12', '现摘牛奶草莓', '/uploaded/1583512133340caomei.jpg', null, null, '88.00', '12', null, '2020-03-07 00:28:54', '', null, '');
INSERT INTO `product` VALUES ('60', '葡萄提子新鲜整箱', '1', '11', '1', '2', '30', '葡萄提子新鲜整箱', '/uploaded/1583512355087putao.jpg', null, null, '69.80', '30', null, '2020-03-07 00:32:36', '', null, '');

-- ----------------------------
-- Table structure for pro_img
-- ----------------------------
DROP TABLE IF EXISTS `pro_img`;
CREATE TABLE `pro_img` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_id` int(11) DEFAULT NULL,
  `url` longtext,
  `flag` int(11) DEFAULT '0' COMMENT '''0''存在，‘1’不存在',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pro_img
-- ----------------------------
INSERT INTO `pro_img` VALUES ('1', '1', 'http://localhost:8765/uploaded/8ea09508b7574af49b6ab382e6ca8565.jpg', '0');
INSERT INTO `pro_img` VALUES ('7', '2', '<div id=\"editor11\"><div id=\"editor11\"><div id=\"editor11\"></div><p><img src=\"http://127.0.0.1:8765/uploaded/80e0084294ac4d74bd00d82d74e6f8e4.jpg\" style=\"max-width:100%;\"><img src=\"http://127.0.0.1:8765/uploaded/0b132668b63a439c808cfd7d21ca5840.jpg\" style=\"max-width: 100%;\"><br></p></div><p><img src=\"http://127.0.0.1:8765/uploaded/0422e41ca3254af89e2e29fec0d73d81.jpg\" style=\"max-width:100%;\"><br></p></div><p><br></p>', '0');
INSERT INTO `pro_img` VALUES ('10', '3', '<p><img src=\"http://127.0.0.1:8765/uploaded/967d6268d6884775a878711e442ef8cd.jpg\" style=\"max-width:100%;\"><img src=\"http://127.0.0.1:8765/uploaded/63dba96203364a41a896e4c6d1599b3f.jpg\" style=\"max-width: 100%;\"><img src=\"http://127.0.0.1:8765/uploaded/0b3e616659a040998732d72ffad3f611.jpg\" style=\"max-width: 100%;\"><img src=\"http://127.0.0.1:8765/uploaded/5801db1a35f8486a97804b476f44d3fc.jpg\" style=\"max-width: 100%;\"><img src=\"http://127.0.0.1:8765/uploaded/be4c57db1d994d4b8cd3798deb4b2f09.jpg\" style=\"max-width: 100%;\"><br></p>', '0');

-- ----------------------------
-- Table structure for pro_vedio
-- ----------------------------
DROP TABLE IF EXISTS `pro_vedio`;
CREATE TABLE `pro_vedio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_id` int(11) DEFAULT NULL,
  `url` longtext,
  `flag` int(11) DEFAULT '0' COMMENT '''0''存在，‘1’不存在',
  `title` varchar(255) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pro_vedio
-- ----------------------------
INSERT INTO `pro_vedio` VALUES ('7', '2', '<video width=\"400px\" height=\"250px\" controls=\"controls\"><source src=\"https://cloud.video.taobao.com/play/u/4010013173/p/1/e/6/t/1/230358322292.mp4\"></video>', '0', '<p><br></p>');
INSERT INTO `pro_vedio` VALUES ('10', '3', '<video width=\"400px\" height=\"250px\" controls=\"controls\"><source src=\"//cloud.video.taobao.com/play/u/2317039795/p/1/e/6/t/1/246003368188.mp4\"></video>', '0', '<p>123456</p>');

-- ----------------------------
-- Table structure for returns
-- ----------------------------
DROP TABLE IF EXISTS `returns`;
CREATE TABLE `returns` (
  `chan_no` varchar(255) NOT NULL COMMENT '退货单编号',
  `cust_id` int(11) DEFAULT NULL COMMENT '客户id',
  `order_no` char(255) DEFAULT NULL COMMENT '订单编号',
  `deliv_date` varchar(255) DEFAULT NULL COMMENT '配送日期',
  `chan_reason` char(50) DEFAULT NULL COMMENT '退货原因',
  `prod_id` char(6) DEFAULT NULL COMMENT '商品编号',
  `qty` int(11) DEFAULT NULL COMMENT '商品数量',
  `status` char(8) DEFAULT '0' COMMENT '退款状态（0，申请中    1退款成功   2退款失败）',
  `flag` varchar(255) DEFAULT '1',
  `content` varchar(255) DEFAULT NULL COMMENT '退货说明',
  `extend3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`chan_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品退货表';

-- ----------------------------
-- Records of returns
-- ----------------------------
INSERT INTO `returns` VALUES ('56202003060327302', '2', '202003060327302', '2020-03-06 04:29:04', '不想要了', null, null, '1', '1', '1', null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色类别编号',
  `role_name` char(15) DEFAULT NULL COMMENT '角色类别名',
  `flag` varchar(255) DEFAULT '1',
  `extend2` varchar(255) DEFAULT NULL,
  `extend3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色类别表';

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('11', 'admin', '1', null, null);
INSERT INTO `role` VALUES ('14', 'manage', '1', null, null);
INSERT INTO `role` VALUES ('15', 'user', '1', null, null);

-- ----------------------------
-- Table structure for sales
-- ----------------------------
DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales` (
  `order_no` int(255) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `cust_id` int(11) DEFAULT NULL COMMENT '客户注册号(id)',
  `tot_amt` decimal(7,2) DEFAULT NULL COMMENT '订单总额',
  `order_date` datetime DEFAULT NULL COMMENT '订货日期',
  `invoice_no` char(20) DEFAULT NULL COMMENT '发票号码',
  `order_status` char(2) DEFAULT '0' COMMENT '订单状态(0.未付款 1.已付款，2正在退款， 3已退款,4退款失败，5已收货)',
  `deliv_date` datetime DEFAULT NULL COMMENT '配送日期',
  `flag` varchar(255) DEFAULT '1' COMMENT '删除标志(1存在，0删除）',
  `extend2` varchar(255) DEFAULT NULL COMMENT '下单时间',
  `extend3` varchar(255) DEFAULT NULL,
  `submit_flag` varchar(255) DEFAULT '1' COMMENT '发货标志(0发货，1未发货，3已收货）',
  PRIMARY KEY (`order_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单总表';

-- ----------------------------
-- Records of sales
-- ----------------------------
INSERT INTO `sales` VALUES ('1', '1', '0.00', '2020-01-11 03:05:31', '202001110305301', '0', '2020-01-12 03:05:31', '0', null, null, '1');
INSERT INTO `sales` VALUES ('2', '1', '0.00', '2020-01-11 03:05:32', '202001110305311', '0', '2020-01-12 03:05:32', '0', null, null, '1');
INSERT INTO `sales` VALUES ('3', '1', '0.00', '2020-01-11 03:05:32', '202001110305321', '0', '2020-01-12 03:05:32', '0', null, null, '1');
INSERT INTO `sales` VALUES ('4', '1', '10.00', '2020-01-11 03:05:36', '202001110305351', '0', '2020-01-12 03:05:36', '0', null, null, '1');
INSERT INTO `sales` VALUES ('5', '1', '10.00', '2020-01-11 03:07:08', '202001110307071', '0', '2020-01-12 03:07:08', '0', null, null, '1');
INSERT INTO `sales` VALUES ('6', '1', '60.00', '2020-01-11 03:08:12', '202001110308121', '0', '2020-01-12 03:08:12', '0', null, null, '1');
INSERT INTO `sales` VALUES ('7', '1', '0.20', '2020-01-11 17:02:00', '202001111702001', '0', '2020-01-12 17:02:00', '0', null, null, '1');
INSERT INTO `sales` VALUES ('8', '2', '0.00', '2020-02-03 22:04:41', '202002032204402', '0', '2020-02-04 22:04:41', '0', null, null, '1');
INSERT INTO `sales` VALUES ('9', '2', '50.00', '2020-02-03 22:04:42', '202002032204422', '0', '2020-02-04 22:04:42', '0', null, null, '1');
INSERT INTO `sales` VALUES ('10', '2', '78.00', '2020-02-13 01:05:59', '202002130105592', '0', '2020-02-14 01:06:00', '0', null, null, '1');
INSERT INTO `sales` VALUES ('11', '2', '60.00', '2020-02-13 01:08:08', '202002130108072', '0', '2020-02-14 01:08:08', '0', null, null, '1');
INSERT INTO `sales` VALUES ('12', '2', '0.00', '2020-02-13 02:27:17', '202002130227172', '0', '2020-02-14 02:27:17', '0', null, null, '1');
INSERT INTO `sales` VALUES ('13', '2', '20.00', '2020-02-14 13:15:02', '202002141315012', '0', '2020-02-15 13:15:02', '0', null, null, '1');
INSERT INTO `sales` VALUES ('14', '2', '40.00', '2020-02-15 17:35:02', '202002151735012', '0', '2020-02-16 17:35:02', '0', null, null, '1');
INSERT INTO `sales` VALUES ('15', '2', '100.00', '2020-02-15 18:07:50', '202002151807492', '0', '2020-02-16 18:07:50', '0', null, null, '1');
INSERT INTO `sales` VALUES ('16', '2', '40.00', '2020-02-15 18:09:11', '202002151809112', '0', '2020-02-16 18:09:11', '0', null, null, '1');
INSERT INTO `sales` VALUES ('17', '2', '0.00', '2020-02-15 18:26:34', '202002151826332', '0', '2020-02-16 18:26:34', '0', null, null, '1');
INSERT INTO `sales` VALUES ('18', '2', '0.00', '2020-02-15 18:26:35', '202002151826352', '0', '2020-02-16 18:26:35', '0', null, null, '1');
INSERT INTO `sales` VALUES ('19', '2', '40.00', '2020-02-15 18:26:38', '202002151826382', '3', '2020-02-16 18:26:38', '0', '2020-02-15 18:02:00', null, '1');
INSERT INTO `sales` VALUES ('20', '2', '0.00', '2020-02-17 02:52:26', '202002170252252', '0', '2020-02-18 02:52:26', '0', null, null, '1');
INSERT INTO `sales` VALUES ('21', '2', '100.00', '2020-02-17 02:52:28', '202002170252282', '0', '2020-02-18 02:52:28', '0', null, null, '1');
INSERT INTO `sales` VALUES ('22', '2', '52.00', '2020-02-17 02:57:47', '202002170257462', '0', '2020-02-18 02:57:47', '0', null, null, '1');
INSERT INTO `sales` VALUES ('23', '2', '20.00', '2020-02-17 03:02:36', '202002170302352', '0', '2020-02-18 03:02:36', '0', null, null, '1');
INSERT INTO `sales` VALUES ('24', '2', '60.00', '2020-02-17 03:10:01', '202002170310002', '0', '2020-02-18 03:10:01', '0', null, null, '1');
INSERT INTO `sales` VALUES ('25', '2', '20.00', '2020-02-17 03:13:15', '202002170313152', '0', '2020-02-18 03:13:15', '0', null, null, '1');
INSERT INTO `sales` VALUES ('26', '2', '20.00', '2020-02-17 03:14:52', '202002170314522', '0', '2020-02-18 03:14:52', '0', null, null, '1');
INSERT INTO `sales` VALUES ('27', '2', '20.00', '2020-02-17 03:16:38', '202002170316372', '0', '2020-02-18 03:16:38', '0', null, null, '1');
INSERT INTO `sales` VALUES ('28', '2', '20.00', '2020-02-17 03:18:16', '202002170318152', '0', '2020-02-18 03:18:16', '0', null, null, '1');
INSERT INTO `sales` VALUES ('29', '2', '20.00', '2020-02-17 04:44:46', '202002170444462', '0', '2020-02-18 04:44:46', '0', null, null, '1');
INSERT INTO `sales` VALUES ('30', '2', '20.00', '2020-02-17 04:53:45', '202002170453452', '0', '2020-02-18 04:53:45', '0', null, null, '1');
INSERT INTO `sales` VALUES ('31', '2', '20.00', '2020-02-17 05:11:01', '202002170511002', '1', '2020-02-18 05:11:01', '0', '2020-02-17 05:02:00', null, '0');
INSERT INTO `sales` VALUES ('32', '2', '0.00', '2020-02-17 05:12:22', '202002170512212', '2', '2020-02-18 05:12:22', '0', null, null, '1');
INSERT INTO `sales` VALUES ('33', '2', '100.00', '2020-02-17 05:12:24', '202002170512232', '2', '2020-02-18 05:12:24', '0', '2020-02-17 05:02:00', null, '1');
INSERT INTO `sales` VALUES ('34', '2', '0.00', '2020-02-17 05:46:58', '202002170546572', '0', '2020-02-18 05:46:58', '0', null, null, '1');
INSERT INTO `sales` VALUES ('35', '2', '20.00', '2020-02-17 05:55:44', '202002170555432', '0', '2020-02-18 05:55:44', '0', null, null, '1');
INSERT INTO `sales` VALUES ('36', '2', '0.00', '2020-02-17 05:56:31', '202002170556312', '0', '2020-02-18 05:56:31', '0', null, null, '1');
INSERT INTO `sales` VALUES ('37', '2', '20.00', '2020-02-17 05:56:34', '202002170556342', '2', '2020-02-18 05:56:34', '0', '2020-02-17 05:02:00', null, '1');
INSERT INTO `sales` VALUES ('38', '2', '10.00', '2020-02-20 18:32:11', '202002201832102', '0', '2020-02-21 18:32:11', '0', null, null, '1');
INSERT INTO `sales` VALUES ('39', '2', '10.00', '2020-02-20 18:32:44', '202002201832432', '1', '2020-02-21 18:32:44', '0', null, null, '0');
INSERT INTO `sales` VALUES ('40', '2', '0.00', '2020-02-20 18:52:00', '202002201852002', '0', '2020-02-21 18:52:00', '0', null, null, '0');
INSERT INTO `sales` VALUES ('41', '2', '10.00', '2020-02-20 18:52:04', '202002201852042', '0', '2020-02-21 18:52:04', '0', null, null, '0');
INSERT INTO `sales` VALUES ('42', '2', '10.00', '2020-02-21 18:16:24', '202002211816232', '1', '2020-02-22 18:16:24', '0', '2020-02-21 18:02:00', null, '1');
INSERT INTO `sales` VALUES ('43', '2', '56.00', '2020-02-23 23:25:51', '202002232325502', '2', '2020-02-24 23:25:51', '0', '2020-02-23 23:02:00', null, '0');
INSERT INTO `sales` VALUES ('44', '2', '10.00', '2020-02-24 03:41:21', '202002240341202', '3', '2020-02-25 03:41:21', '0', '2020-02-24 03:02:00', null, '1');
INSERT INTO `sales` VALUES ('45', '2', '10.00', '2020-02-24 04:28:53', '202002240428522', '1', '2020-02-25 04:28:53', '0', '2020-02-24 04:02:00', null, '3');
INSERT INTO `sales` VALUES ('46', '2', '10.00', '2020-02-24 04:33:05', '202002240433052', '2', '2020-02-25 04:33:05', '0', '2020-02-24 04:02:00', null, '1');
INSERT INTO `sales` VALUES ('47', '2', '12.00', '2020-02-24 04:40:22', '202002240440212', '1', '2020-02-25 04:40:22', '0', '2020-02-24 04:02:00', null, '3');
INSERT INTO `sales` VALUES ('48', '2', '56.00', '2020-02-25 04:55:05', '202002250455052', '0', '2020-02-26 04:55:05', '0', null, null, '1');
INSERT INTO `sales` VALUES ('49', '2', '56.00', '2020-02-25 04:55:40', '202002250455402', '1', '2020-02-26 04:55:40', '0', '2020-02-25 04:02:00', null, '0');
INSERT INTO `sales` VALUES ('50', '2', '30.00', '2020-02-25 05:36:55', '202002250536542', '1', '2020-02-26 05:36:55', '0', '2020-02-25 05:02:00', null, '3');
INSERT INTO `sales` VALUES ('51', '2', '89.90', '2020-02-26 05:26:41', '202002260526412', '1', '2020-02-27 05:26:41', '0', '2020-02-26 05:02:00', null, '0');
INSERT INTO `sales` VALUES ('52', '2', '20.00', '2020-03-05 23:43:14', '202003052343132', '2', '2020-03-06 23:43:14', '0', '2020-03-05 23:03:00', null, '1');
INSERT INTO `sales` VALUES ('53', '2', '10.00', '2020-03-06 02:58:46', '202003060258462', '1', '2020-03-07 02:58:46', '0', '2020-03-06 02:03:00', null, '0');
INSERT INTO `sales` VALUES ('54', '2', '65.00', '2020-03-06 03:27:30', '202003060327302', '3', '2020-03-07 03:27:30', '1', '2020-03-06 03:03:00', null, '0');
INSERT INTO `sales` VALUES ('55', '2', '63.90', '2020-03-06 18:28:13', '202003061828132', '1', '2020-03-07 18:28:13', '0', '2020-03-06 18:03:00', null, '1');
INSERT INTO `sales` VALUES ('56', '2', '142.00', '2020-03-10 03:58:15', '202003100358142', '0', '2020-03-11 03:58:15', '0', null, null, '1');
INSERT INTO `sales` VALUES ('57', '2', '142.00', '2020-03-10 04:02:46', '202003100402462', '0', '2020-03-11 04:02:46', '0', null, null, '1');
INSERT INTO `sales` VALUES ('58', '2', '142.00', '2020-03-10 04:04:06', '202003100404062', '0', '2020-03-11 04:04:06', '0', null, null, '1');
INSERT INTO `sales` VALUES ('59', '2', '89.00', '2020-03-10 04:36:11', '202003100436112', '0', '2020-03-11 04:36:11', '0', null, null, '1');
INSERT INTO `sales` VALUES ('60', '2', '178.00', '2020-03-10 04:37:45', '202003100437442', '0', '2020-03-11 04:37:45', '0', null, null, '1');
INSERT INTO `sales` VALUES ('61', '2', '0.00', '2020-03-16 03:55:28', '202003160355272', '0', '2020-03-17 03:55:28', '0', null, null, '1');
INSERT INTO `sales` VALUES ('62', '2', '88.00', '2020-03-16 03:55:31', '202003160355302', '0', '2020-03-17 03:55:31', '0', null, null, '1');
INSERT INTO `sales` VALUES ('63', '2', '88.00', '2020-03-16 03:56:05', '202003160356052', '0', '2020-03-17 03:56:05', '0', null, null, '1');
INSERT INTO `sales` VALUES ('64', '2', '17.00', '2020-03-19 04:09:04', '202003190409032', '0', '2020-03-20 04:09:04', '0', null, null, '1');
INSERT INTO `sales` VALUES ('65', '2', '100.00', '2020-03-19 04:11:08', '202003190411072', '0', '2020-03-20 04:11:08', '0', null, null, '1');
INSERT INTO `sales` VALUES ('66', '2', '10.00', '2020-03-23 16:24:25', '202003231624252', '1', '2020-03-24 16:24:25', '1', '2020-03-23 16:03:00', null, '3');

-- ----------------------------
-- Table structure for sale_item
-- ----------------------------
DROP TABLE IF EXISTS `sale_item`;
CREATE TABLE `sale_item` (
  `order_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `prod_id` int(11) DEFAULT NULL COMMENT '商品编号',
  `unit_price` decimal(7,2) DEFAULT NULL COMMENT '商品单价',
  `dis_price` decimal(7,2) DEFAULT NULL COMMENT '商品折后价',
  `qty` int(11) DEFAULT NULL COMMENT '商品数量',
  `order_date` datetime DEFAULT NULL COMMENT '订货日期',
  `invoice_no` varchar(255) DEFAULT NULL COMMENT '订单编号',
  `extend2` varchar(255) DEFAULT NULL COMMENT '暂存商品图片',
  `extend3` varchar(255) DEFAULT NULL COMMENT '暂存商品描述',
  PRIMARY KEY (`order_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='订单明细表';

-- ----------------------------
-- Records of sale_item
-- ----------------------------
INSERT INTO `sale_item` VALUES ('1', '2', '10.00', null, '1', '2020-01-11 03:05:36', '202001110305351', null, null);
INSERT INTO `sale_item` VALUES ('2', '2', '10.00', null, '1', '2020-01-11 03:07:08', '202001110307071', null, null);
INSERT INTO `sale_item` VALUES ('3', '2', '10.00', null, '1', '2020-01-11 03:08:12', '202001110308121', null, null);
INSERT INTO `sale_item` VALUES ('4', '3', '50.00', null, '1', '2020-01-11 03:08:13', '202001110308121', null, null);
INSERT INTO `sale_item` VALUES ('5', '40', '0.20', null, '2', '2020-01-11 17:02:00', '202001111702001', null, null);
INSERT INTO `sale_item` VALUES ('6', '3', '50.00', null, '1', '2020-02-03 22:04:42', '202002032204422', null, null);
INSERT INTO `sale_item` VALUES ('7', '16', '78.00', null, '1', '2020-02-13 01:06:00', '202002130105592', null, null);
INSERT INTO `sale_item` VALUES ('8', '3', '50.00', null, '1', '2020-02-13 01:08:08', '202002130108072', null, null);
INSERT INTO `sale_item` VALUES ('9', '2', '10.00', null, '1', '2020-02-13 01:08:08', '202002130108072', null, null);
INSERT INTO `sale_item` VALUES ('10', '6', '20.00', null, '1', '2020-02-14 13:15:02', '202002141315012', null, null);
INSERT INTO `sale_item` VALUES ('11', '6', '40.00', null, '2', '2020-02-15 17:35:02', '202002151735012', null, null);
INSERT INTO `sale_item` VALUES ('12', '3', '100.00', null, '2', '2020-02-15 18:07:50', '202002151807492', null, null);
INSERT INTO `sale_item` VALUES ('13', '6', '40.00', null, '2', '2020-02-15 18:09:11', '202002151809112', null, null);
INSERT INTO `sale_item` VALUES ('14', '6', '40.00', null, '2', '2020-02-15 18:26:38', '202002151826382', null, null);
INSERT INTO `sale_item` VALUES ('15', '3', '100.00', null, '2', '2020-02-17 02:52:28', '202002170252282', null, null);
INSERT INTO `sale_item` VALUES ('16', '5', '52.00', null, '1', '2020-02-17 02:57:47', '202002170257462', null, null);
INSERT INTO `sale_item` VALUES ('17', '6', '20.00', null, '1', '2020-02-17 03:02:36', '202002170302352', null, null);
INSERT INTO `sale_item` VALUES ('18', '6', '60.00', null, '3', '2020-02-17 03:10:01', '202002170310002', null, null);
INSERT INTO `sale_item` VALUES ('19', '6', '20.00', null, '1', '2020-02-17 03:13:16', '202002170313152', null, null);
INSERT INTO `sale_item` VALUES ('20', '6', '20.00', null, '1', '2020-02-17 03:14:52', '202002170314522', null, null);
INSERT INTO `sale_item` VALUES ('21', '6', '20.00', null, '1', '2020-02-17 03:16:38', '202002170316372', null, null);
INSERT INTO `sale_item` VALUES ('22', '6', '20.00', null, '1', '2020-02-17 03:18:16', '202002170318152', null, null);
INSERT INTO `sale_item` VALUES ('23', '6', '20.00', null, '1', '2020-02-17 04:44:46', '202002170444462', null, null);
INSERT INTO `sale_item` VALUES ('24', '6', '20.00', null, '1', '2020-02-17 04:53:46', '202002170453452', null, null);
INSERT INTO `sale_item` VALUES ('25', '6', '20.00', null, '1', '2020-02-17 05:11:01', '202002170511002', null, null);
INSERT INTO `sale_item` VALUES ('26', '3', '100.00', null, '2', '2020-02-17 05:12:24', '202002170512232', null, null);
INSERT INTO `sale_item` VALUES ('27', '6', '20.00', null, '1', '2020-02-17 05:55:44', '202002170555432', null, null);
INSERT INTO `sale_item` VALUES ('28', '6', '20.00', null, '1', '2020-02-17 05:56:34', '202002170556342', null, null);
INSERT INTO `sale_item` VALUES ('29', '2', '10.00', null, '1', '2020-02-20 18:32:11', '202002201832102', null, null);
INSERT INTO `sale_item` VALUES ('30', '2', '10.00', null, '1', '2020-02-20 18:32:44', '202002201832432', null, null);
INSERT INTO `sale_item` VALUES ('31', '2', '10.00', null, '1', '2020-02-20 18:52:04', '202002201852042', null, null);
INSERT INTO `sale_item` VALUES ('32', '2', '10.00', null, '1', '2020-02-21 18:16:24', '202002211816232', null, null);
INSERT INTO `sale_item` VALUES ('33', '39', '56.00', null, '1', '2020-02-23 23:25:51', '202002232325502', null, null);
INSERT INTO `sale_item` VALUES ('34', '25', '10.00', null, '1', '2020-02-24 03:41:21', '202002240341202', null, null);
INSERT INTO `sale_item` VALUES ('35', '2', '10.00', null, '1', '2020-02-24 04:28:53', '202002240428522', null, null);
INSERT INTO `sale_item` VALUES ('36', '2', '10.00', null, '1', '2020-02-24 04:33:05', '202002240433052', null, null);
INSERT INTO `sale_item` VALUES ('37', '26', '12.00', null, '1', '2020-02-24 04:40:22', '202002240440212', null, null);
INSERT INTO `sale_item` VALUES ('38', '39', '56.00', null, '1', '2020-02-25 04:55:06', '202002250455052', null, null);
INSERT INTO `sale_item` VALUES ('39', '39', '56.00', null, '1', '2020-02-25 04:55:40', '202002250455402', null, null);
INSERT INTO `sale_item` VALUES ('40', '2', '10.00', null, '1', '2020-02-25 05:36:55', '202002250536542', null, null);
INSERT INTO `sale_item` VALUES ('41', '6', '20.00', null, '1', '2020-02-25 05:36:55', '202002250536542', null, null);
INSERT INTO `sale_item` VALUES ('42', '40', '89.90', null, '1', '2020-02-26 05:26:41', '202002260526412', null, null);
INSERT INTO `sale_item` VALUES ('43', '6', '20.00', null, '1', '2020-03-05 23:43:14', '202003052343132', null, null);
INSERT INTO `sale_item` VALUES ('44', '2', '10.00', null, '1', '2020-03-06 02:58:46', '202003060258462', null, null);
INSERT INTO `sale_item` VALUES ('45', '17', '65.00', null, '1', '2020-03-06 03:27:31', '202003060327302', null, null);
INSERT INTO `sale_item` VALUES ('46', '56', '63.90', null, '1', '2020-03-06 18:28:13', '202003061828132', null, null);
INSERT INTO `sale_item` VALUES ('47', '58', '142.00', null, '1', '2020-03-10 03:58:15', '202003100358142', null, null);
INSERT INTO `sale_item` VALUES ('48', '58', '142.00', null, '1', '2020-03-10 04:02:46', '202003100402462', null, null);
INSERT INTO `sale_item` VALUES ('49', '58', '142.00', null, '1', '2020-03-10 04:04:06', '202003100404062', null, null);
INSERT INTO `sale_item` VALUES ('50', '18', '89.00', null, '1', '2020-03-10 04:36:11', '202003100436112', null, null);
INSERT INTO `sale_item` VALUES ('51', '18', '178.00', null, '2', '2020-03-10 04:37:45', '202003100437442', null, null);
INSERT INTO `sale_item` VALUES ('52', '59', '88.00', null, '1', '2020-03-16 03:55:31', '202003160355302', null, null);
INSERT INTO `sale_item` VALUES ('53', '59', '88.00', null, '1', '2020-03-16 03:56:05', '202003160356052', null, null);
INSERT INTO `sale_item` VALUES ('54', '22', '17.00', null, '1', '2020-03-19 04:09:04', '202003190409032', null, null);
INSERT INTO `sale_item` VALUES ('55', '23', '100.00', null, '1', '2020-03-19 04:11:08', '202003190411072', null, null);
INSERT INTO `sale_item` VALUES ('56', '2', '10.00', null, '1', '2020-03-23 16:24:25', '202003231624252', null, null);

-- ----------------------------
-- Table structure for shopcart
-- ----------------------------
DROP TABLE IF EXISTS `shopcart`;
CREATE TABLE `shopcart` (
  `shop_no` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车编号',
  `cust_id` int(6) DEFAULT NULL COMMENT '客户id',
  `prod_id` int(6) DEFAULT NULL COMMENT '商品id',
  `unit_price` decimal(7,2) DEFAULT NULL COMMENT '商品单价',
  `dis_price` decimal(9,2) DEFAULT NULL COMMENT '商品折后价',
  `qty` int(11) DEFAULT NULL COMMENT '商品数量',
  `buy` char(4) DEFAULT '0' COMMENT '是否购买',
  `pro_totamt` decimal(7,2) DEFAULT NULL COMMENT '商品总金额',
  `flag` varchar(255) DEFAULT '1' COMMENT '1是存在  2是删除',
  `image` varchar(255) DEFAULT NULL,
  `extend3` varchar(255) DEFAULT NULL COMMENT '暂存商品描述',
  PRIMARY KEY (`shop_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='商品暂存表';

-- ----------------------------
-- Records of shopcart
-- ----------------------------
INSERT INTO `shopcart` VALUES ('1', '1', '2', '10.00', null, '1', '0', '10.00', '1', '/uploaded/155470557805411.jpg', null);
INSERT INTO `shopcart` VALUES ('2', '1', '3', '50.00', null, '1', '0', '50.00', '1', '/images/tj.png', null);
INSERT INTO `shopcart` VALUES ('3', '1', '40', '0.10', null, '2', '0', '0.20', '1', '/uploaded/1578733264758123.jpg', null);
INSERT INTO `shopcart` VALUES ('4', '2', '3', '50.00', null, '1', '0', '50.00', '0', '/images/tj.png', null);
INSERT INTO `shopcart` VALUES ('5', '2', '2', '10.00', null, '1', '0', '10.00', '0', '/uploaded/155470557805411.jpg', null);
INSERT INTO `shopcart` VALUES ('6', '2', '2', '10.00', null, '1', '0', '10.00', '0', '/uploaded/1581527488520123.jpg', null);
INSERT INTO `shopcart` VALUES ('7', '2', '6', '20.00', null, '2', '1', '40.00', '1', '/images/2.jpg', null);
INSERT INTO `shopcart` VALUES ('8', '2', '3', '50.00', null, '2', '1', '100.00', '1', '/images/tj.png', null);
INSERT INTO `shopcart` VALUES ('9', '2', '6', '20.00', null, '1', '1', '20.00', '1', '/images/2.jpg', null);
INSERT INTO `shopcart` VALUES ('10', '2', '7', '5.00', null, '1', '0', '5.00', '0', '/images/5.jpg', null);
INSERT INTO `shopcart` VALUES ('11', '2', '6', '20.00', null, '1', '1', '20.00', '1', '/images/2.jpg', null);
INSERT INTO `shopcart` VALUES ('12', '2', '2', '10.00', null, '1', '1', '10.00', '1', '/uploaded/155470557805411.jpg', null);
INSERT INTO `shopcart` VALUES ('13', '2', '39', '56.00', null, '1', '1', '56.00', '1', '/uploaded/niurou.jpg', null);
INSERT INTO `shopcart` VALUES ('14', '2', '7', '5.00', null, '1', '0', '5.00', '0', '/images/5.jpg', null);
INSERT INTO `shopcart` VALUES ('15', '2', '2', '10.00', null, '1', '1', '10.00', '1', '/uploaded/155470557805411.jpg', null);
INSERT INTO `shopcart` VALUES ('16', '2', '26', '12.00', null, '1', '1', '12.00', '1', '/images/1.jpg', null);
INSERT INTO `shopcart` VALUES ('17', '2', '2', '10.00', null, '1', '1', '10.00', '1', '/uploaded/155470557805411.jpg', null);
INSERT INTO `shopcart` VALUES ('18', '2', '6', '20.00', null, '1', '1', '20.00', '1', '/images/2.jpg', null);
INSERT INTO `shopcart` VALUES ('19', '2', '6', '20.00', null, '1', '1', '20.00', '1', '/images/2.jpg', null);
INSERT INTO `shopcart` VALUES ('20', '2', '2', '10.00', null, '1', '1', '10.00', '1', '/uploaded/1583434673995pingguo1.jpg', null);
INSERT INTO `shopcart` VALUES ('21', '2', '58', '142.00', null, '1', '0', '142.00', '1', '/uploaded/1583512003778chengzhi.jpg', null);
INSERT INTO `shopcart` VALUES ('22', '2', '2', '10.00', null, '1', '0', '10.00', '1', '/uploaded/1583434673995pingguo1.jpg', null);
INSERT INTO `shopcart` VALUES ('23', '2', '59', '88.00', null, '1', '0', '88.00', '1', '/uploaded/1583512133340caomei.jpg', null);
INSERT INTO `shopcart` VALUES ('24', '2', '22', '17.00', null, '1', '0', '17.00', '1', '/images/tj1.png', null);
INSERT INTO `shopcart` VALUES ('25', '2', '2', '10.00', null, '1', '1', '10.00', '1', '/uploaded/1583434673995pingguo1.jpg', null);

-- ----------------------------
-- Table structure for sys_authority
-- ----------------------------
DROP TABLE IF EXISTS `sys_authority`;
CREATE TABLE `sys_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `identity` varchar(255) DEFAULT NULL COMMENT '三员身份(安全员1、管理员2、审计员3)',
  `username` varchar(255) DEFAULT NULL COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '用户登录名',
  `salt` varchar(255) DEFAULT NULL COMMENT '用户密码（加盐,md5之后）',
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  `login_time` bigint(20) DEFAULT '0' COMMENT '登录次数',
  `extend1` varchar(255) DEFAULT NULL,
  `extend2` varchar(255) DEFAULT NULL,
  `extend3` varchar(255) DEFAULT NULL,
  `flag` char(4) DEFAULT '1' COMMENT '''1’存在,''0''不存在',
  `role_no` char(4) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='管理员表';

-- ----------------------------
-- Records of sys_authority
-- ----------------------------
INSERT INTO `sys_authority` VALUES ('1', '1', 'admin', '038bdaf98f2037b31f1e75b5b4c9b26e', '2j24H1SFCDjzgZdAnIej9A==', null, null, null, null, '0', null, null, null, '1', '11');
INSERT INTO `sys_authority` VALUES ('11', null, 'admin11', '854cc025d7cbbd4c8ae5106aac0986ae', 'YWRtaW4xMQ==', null, null, null, null, '0', null, null, null, '1', '11');
INSERT INTO `sys_authority` VALUES ('13', null, 'user', '098d2c478e9c11555ce2823231e02ec1', 'dXNlcg==', null, null, null, null, '0', null, null, null, '1', '15');
INSERT INTO `sys_authority` VALUES ('14', null, 'admin2', 'c3270271f36e5e795e54c2721896102e', 'YWRtaW4y', null, null, null, null, '0', null, null, null, '1', '11');
INSERT INTO `sys_authority` VALUES ('15', null, 'manage', 'e83ff89e734b5079fe2bc9f8478b988c', 'bWFuYWdl', null, null, null, null, '0', null, null, null, '1', '14');

-- ----------------------------
-- Table structure for sys_authority_question
-- ----------------------------
DROP TABLE IF EXISTS `sys_authority_question`;
CREATE TABLE `sys_authority_question` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `authority_id` int(30) DEFAULT NULL COMMENT '用户id',
  `authority_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `question1` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '问题1',
  `question2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `question3` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `answer1` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '答案1',
  `answer2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `answer3` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `flag` varchar(255) COLLATE utf8_bin DEFAULT '1',
  `status` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '三员身份(安全员1、管理员2、审计员3)',
  `updatetime` datetime(6) DEFAULT NULL COMMENT '修改时间',
  `extend1` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '拓展字段1',
  `extend2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `extend3` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `extend4` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `extend5` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `extend6` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='管理员密保问题与答案表';

-- ----------------------------
-- Records of sys_authority_question
-- ----------------------------
INSERT INTO `sys_authority_question` VALUES ('1', '1', 'admin', '你的真实姓名', '你的工号', '你的手机号', '', null, null, '1', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名字',
  `sort` int(20) DEFAULT NULL COMMENT '菜单排序',
  `href` varchar(50) DEFAULT NULL COMMENT '菜单链接',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `target` varchar(50) DEFAULT NULL COMMENT '菜单目标',
  `permission` varchar(50) DEFAULT NULL COMMENT '权限标识',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '菜单父ID',
  `parent_ids` varchar(255) DEFAULT NULL COMMENT '菜单所有父ID',
  `status` tinyint(4) DEFAULT '1' COMMENT '菜单状态（启用1禁用2）',
  `type` tinyint(4) DEFAULT '1' COMMENT '菜单类型(1菜单2按钮）',
  `flag` tinyint(4) DEFAULT '1' COMMENT '删除标记（1表示可用，0表示不可用，2表示待授予，3表示待撤回）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_by` bigint(20) DEFAULT NULL COMMENT '修改人',
  `is_btn` varchar(2) DEFAULT '0' COMMENT '默认为0  1代表按钮',
  `note` text COMMENT '备注',
  `extend1` varchar(255) DEFAULT NULL,
  `extend2` varchar(255) DEFAULT NULL,
  `extend3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='系统菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for warehouse
-- ----------------------------
DROP TABLE IF EXISTS `warehouse`;
CREATE TABLE `warehouse` (
  `wh_no` int(5) NOT NULL AUTO_INCREMENT COMMENT '仓库编号',
  `wh_name` char(10) DEFAULT NULL COMMENT '仓库名称',
  `flag` varchar(255) DEFAULT '1',
  `extend2` varchar(255) DEFAULT NULL,
  `extend3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`wh_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='仓库表(商品品牌表)';

-- ----------------------------
-- Records of warehouse
-- ----------------------------
INSERT INTO `warehouse` VALUES ('1', '三只松鼠', '1', null, null);
INSERT INTO `warehouse` VALUES ('2', '百草味', '1', null, null);
INSERT INTO `warehouse` VALUES ('3', '良品铺子', '1', null, null);
INSERT INTO `warehouse` VALUES ('4', '三星', '0', null, null);
INSERT INTO `warehouse` VALUES ('5', '怡宝', '1', null, null);
INSERT INTO `warehouse` VALUES ('6', '百事可乐', '1', null, null);
INSERT INTO `warehouse` VALUES ('7', '农夫山泉', '1', null, null);
INSERT INTO `warehouse` VALUES ('8', '盐津铺子', '1', null, null);
INSERT INTO `warehouse` VALUES ('9', '卫龙', '1', null, null);
INSERT INTO `warehouse` VALUES ('10', '梦强', '1', null, null);
INSERT INTO `warehouse` VALUES ('11', '王小二', '1', null, null);
INSERT INTO `warehouse` VALUES ('12', '娃哈哈', '1', null, null);
INSERT INTO `warehouse` VALUES ('14', '维他', '1', null, null);
