-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema penguin
--

CREATE DATABASE IF NOT EXISTS penguin;
USE penguin;

--
-- Definition of table `branchname`
--

DROP TABLE IF EXISTS `branchname`;
CREATE TABLE `branchname` (
  `CompanyID` int(10) unsigned NOT NULL,
  `BranchID` int(10) unsigned NOT NULL,
  `BranchName` varchar(45) default NULL,
  `Entryby` varchar(45) default NULL,
  `EDate` datetime default NULL,
  `Updateby` varchar(45) default NULL,
  `UDate` date default NULL,
  PRIMARY KEY  (`BranchID`),
  KEY `FK_branchName_1` (`CompanyID`)
) ENGINE=MyISAM AUTO_INCREMENT=2001 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `branchname`
--

/*!40000 ALTER TABLE `branchname` DISABLE KEYS */;
/*!40000 ALTER TABLE `branchname` ENABLE KEYS */;


--
-- Definition of table `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `companyID` int(10) unsigned NOT NULL auto_increment,
  `companyName` varchar(45) default NULL,
  `entryBy` varchar(45) default NULL,
  `e_Date` date default NULL,
  `updateBy` varchar(45) default NULL,
  `uDate` date default NULL,
  PRIMARY KEY  (`companyID`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `company`
--

/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` (`companyID`,`companyName`,`entryBy`,`e_Date`,`updateBy`,`uDate`) VALUES 
 (1,'কামাল ',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;


--
-- Definition of table `oauth_client_details`
--

DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `CLIENT_ID` varchar(255) NOT NULL,
  `CLIENT_SECRET` varchar(255) NOT NULL,
  `RESOURCE_IDS` varchar(255) default NULL,
  `SCOPE` varchar(255) default NULL,
  `AUTHORIZED_GRANT_TYPES` varchar(255) default NULL,
  `WEB_SERVER_REDIRECT_URI` varchar(255) default NULL,
  `AUTHORITIES` varchar(255) default NULL,
  `ACCESS_TOKEN_VALIDITY` int(11) default NULL,
  `REFRESH_TOKEN_VALIDITY` int(11) default NULL,
  `ADDITIONAL_INFORMATION` varchar(4096) default NULL,
  `AUTOAPPROVE` varchar(255) default NULL,
  PRIMARY KEY  (`CLIENT_ID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `oauth_client_details`
--

/*!40000 ALTER TABLE `oauth_client_details` DISABLE KEYS */;
INSERT INTO `oauth_client_details` (`CLIENT_ID`,`CLIENT_SECRET`,`RESOURCE_IDS`,`SCOPE`,`AUTHORIZED_GRANT_TYPES`,`WEB_SERVER_REDIRECT_URI`,`AUTHORITIES`,`ACCESS_TOKEN_VALIDITY`,`REFRESH_TOKEN_VALIDITY`,`ADDITIONAL_INFORMATION`,`AUTOAPPROVE`) VALUES 
 ('USER_CLIENT_APP','{bcrypt}$2a$10$EOs8VROb14e7ZnydvXECA.4LoIhPOoFHKvVF/iBZ/ker17Eocz4Vi','USER_CLIENT_RESOURCE,USER_ADMIN_RESOURCE','role_admin,role_user','authorization_code,password,refresh_token,implicit',NULL,NULL,900,3600,'{}',NULL);
/*!40000 ALTER TABLE `oauth_client_details` ENABLE KEYS */;


--
-- Definition of table `permission`
--

DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `permission`
--

/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` (`id`,`name`) VALUES 
 (1,'can_create_user'),
 (4,'can_delete_user'),
 (3,'can_read_user'),
 (2,'can_update_user');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;


--
-- Definition of table `permission_role`
--

DROP TABLE IF EXISTS `permission_role`;
CREATE TABLE `permission_role` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  KEY `FK3tuvkbyi6wcytyg21hvpd6txw` (`permission_id`),
  KEY `FK50sfdcvbvdaclpn7wp4uop4ml` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `permission_role`
--

/*!40000 ALTER TABLE `permission_role` DISABLE KEYS */;
INSERT INTO `permission_role` (`role_id`,`permission_id`) VALUES 
 (1,1),
 (1,2),
 (1,3),
 (1,4),
 (2,3);
/*!40000 ALTER TABLE `permission_role` ENABLE KEYS */;


--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`,`name`) VALUES 
 (1,'role_admin'),
 (2,'role_user');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `role_user`
--

DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKiqpmjd2qb4rdkej916ymonic6` (`role_id`),
  KEY `FKhvai2k29vlwpt9wod4sw4ghmn` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role_user`
--

/*!40000 ALTER TABLE `role_user` DISABLE KEYS */;
INSERT INTO `role_user` (`user_id`,`role_id`) VALUES 
 (1,1),
 (2,2);
/*!40000 ALTER TABLE `role_user` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `account_expired` bit(1) default NULL,
  `account_locked` bit(1) default NULL,
  `credentials_expired` bit(1) default NULL,
  `email` varchar(255) default NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`account_expired`,`account_locked`,`credentials_expired`,`email`,`enabled`,`password`,`username`) VALUES 
 (1,0x00,0x00,0x00,'dg12kumbhar@gmail.com',0x01,'{bcrypt}$2a$10$EOs8VROb14e7ZnydvXECA.4LoIhPOoFHKvVF/iBZ/ker17Eocz4Vi','admin'),
 (2,0x00,0x00,0x00,'user@gmail.com',0x01,'{bcrypt}$2a$10$EOs8VROb14e7ZnydvXECA.4LoIhPOoFHKvVF/iBZ/ker17Eocz4Vi','user');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment,
  `account_expired` bit(1) default NULL,
  `account_locked` bit(1) default NULL,
  `credentials_expired` bit(1) default NULL,
  `email` varchar(255) default NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
