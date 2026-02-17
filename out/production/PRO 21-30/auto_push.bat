@echo off
cd /d "C:\Users\windows10\Desktop\PRO 21-30"
git pull origin main --rebase
git add .
git commit -m "Automated hourly sync: %date% %time%"
git push origin main
