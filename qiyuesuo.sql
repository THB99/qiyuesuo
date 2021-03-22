/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.33 : Database - qiyuesuo
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`qiyuesuo` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `qiyuesuo`;

/*Table structure for table `download_file` */

DROP TABLE IF EXISTS `download_file`;

CREATE TABLE `download_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id自增',
  `uuid` char(200) DEFAULT NULL COMMENT 'uuid',
  `size` bigint(20) NOT NULL COMMENT '文件大小',
  `type` char(100) NOT NULL COMMENT '文件类型',
  `originalname` char(200) NOT NULL COMMENT '原始文件名',
  `createtime` datetime NOT NULL COMMENT '创建时间',
  `address` char(200) NOT NULL COMMENT '文件保存目录地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4;

/*Data for the table `download_file` */

insert  into `download_file`(`id`,`uuid`,`size`,`type`,`originalname`,`createtime`,`address`) values (28,'2262ef23-81fc-4899-a247-ffd5161fc87f',4293,'md','Nacos.md','2021-03-22 21:52:10','E:\\myCode\\qiyuesuo\\uploadFile\\20210322\\2262ef23-81fc-4899-a247-ffd5161fc87f.md'),(29,'a184a7cf-ade5-48fc-8e16-9e9950dc8a6c',142848,'doc','毕业设计（论文）外文参考资料-唐洪斌.doc','2021-03-22 21:52:22','E:\\myCode\\qiyuesuo\\uploadFile\\20210322\\a184a7cf-ade5-48fc-8e16-9e9950dc8a6c.doc'),(30,'601d36bd-ad59-446a-967f-20687e3be325',75776,'pdf','唐洪斌的简历 .pdf','2021-03-22 21:52:35','E:\\myCode\\qiyuesuo\\uploadFile\\20210322\\601d36bd-ad59-446a-967f-20687e3be325.pdf'),(31,'0d27138f-e9e9-47f1-85f1-708b32bf1c54',1002457,'pdf','ACR17-4.pdf','2021-03-22 22:10:34','E:\\myCode\\qiyuesuo\\uploadFile\\20210322\\0d27138f-e9e9-47f1-85f1-708b32bf1c54.pdf'),(32,'bf45dcbd-c11e-4a19-91d5-ebc496b746e3',88837,'md','Spring Boot-高级篇.md','2021-03-22 22:27:13','E:\\myCode\\qiyuesuo\\uploadFile\\20210322\\bf45dcbd-c11e-4a19-91d5-ebc496b746e3.md'),(33,'9cc18520-cc20-4afc-b396-da3927a87a08',5545979,'html','simpread-Java 面试题 - 个人笔记_wts563540 的博客 - CSDN 博客_java 面试.html','2021-03-22 22:27:30','E:\\myCode\\qiyuesuo\\uploadFile\\20210322\\9cc18520-cc20-4afc-b396-da3927a87a08.html'),(34,'1c23d5d2-e15e-42da-8406-5742d86a73f5',166264,'md','Spring Boot-核心篇.md','2021-03-22 23:32:36','E:\\myCode\\qiyuesuo\\uploadFile\\20210322\\1c23d5d2-e15e-42da-8406-5742d86a73f5.md'),(35,'fcae2487-3d5e-4f7b-95be-d55dec28471b',4293,'md','Nacos.md','2021-03-22 23:33:59','E:\\myCode\\qiyuesuo\\uploadFile\\20210322\\fcae2487-3d5e-4f7b-95be-d55dec28471b.md'),(36,'7913780c-0f8d-4a47-98b6-bc2f362ce21a',119296,'doc','1、毕业设计（论文）任务书-唐洪斌 (1).doc','2021-03-22 23:34:10','E:\\myCode\\qiyuesuo\\uploadFile\\20210322\\7913780c-0f8d-4a47-98b6-bc2f362ce21a.doc'),(37,'72955845-9d9f-40c0-9bf9-f242470af7fe',1002457,'pdf','ACR17-4.pdf','2021-03-22 23:57:07','E:\\myCode\\qiyuesuo\\uploadFile\\20210322\\72955845-9d9f-40c0-9bf9-f242470af7fe.pdf');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
