@echo off
echo ==================================
echo        正在启动项目...
echo ==================================
docker-compose up -d
echo.
echo 启动完成！
echo 前端：http://localhost
echo 后端：http://localhost:8080
pause