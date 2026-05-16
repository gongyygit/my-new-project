@echo off
echo 正在重启项目...
docker-compose down
docker-compose up -d
echo 重启完成！
pause