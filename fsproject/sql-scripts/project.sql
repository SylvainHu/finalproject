CREATE DATABASE IF NOT EXISTS `project`;
USE `project`;

CREATE USER IF NOT EXISTS 'springstudent'@'localhost' IDENTIFIED BY 'springstudent';

-- Grant all privileges to the user on the project database
GRANT ALL PRIVILEGES ON `project`.* TO 'springstudent'@'localhost';

-- Apply the changes
FLUSH PRIVILEGES;