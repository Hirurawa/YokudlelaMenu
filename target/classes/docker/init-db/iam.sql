CREATE DATABASE  IF NOT EXISTS `iam` CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'iam'@'%' IDENTIFIED BY 'iam';
GRANT ALL PRIVILEGES ON `iam`.* TO 'iam'@'%'
