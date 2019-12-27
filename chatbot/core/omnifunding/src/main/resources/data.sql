CREATE DATABASE IF NOT EXISTS donate;
create user 'ubuntu'@'%' identified by 'N9sdhpi2Dhn2';
grant all on donate.* to 'ubuntu'@'%';