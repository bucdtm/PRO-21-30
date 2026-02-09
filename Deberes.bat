@echo off
:: Cambiar la consola a UTF-8 para que se vean tildes y emojis
chcp 65001 >nul
setlocal

:: Definir el caracter de escape para colores
for /f "tokens=1,2 delims=#" %%a in ('"prompt #$H#$E# & echo on & for %%b in (1) do rem"') do set "ESC=%%b"

cls
echo %ESC%[1;35m==================================================%ESC%[0m
echo %ESC%[1;35m       📅 PLANIFICADOR DE TAREAS - ACADÉMICO %ESC%[0m
echo %ESC%[1;35m==================================================%ESC%[0m
echo.
echo %ESC%[1;34m--- 💻 PROGRAMACIÓN ---%ESC%[0m
echo %ESC%[1;31m[!] CRÍTICO (VENCIDO)%ESC%[0m
echo   • %ESC%[1;31mUD5 EJ2:%ESC%[0m POO Clases y Objetos 2
echo   • %ESC%[1;31mUD5:%ESC%[0m "La orden del Código Cerrado"
echo   • %ESC%[1;31mUD6 EJ1:%ESC%[0m (Vehículo) Uso avanzado de clases
echo.
echo %ESC%[1;33m[>] PRÓXIMAMENTE%ESC%[0m
echo   • %ESC%[1;32mUD6 EJ5 (Ruleta):%ESC%[0m Abre el 13 de feb. %ESC%[1;36m[PENDIENTE ENVÍO]%ESC%[0m
echo   • %ESC%[1;37mUD6 EJ3 (Electrodom.):%ESC%[0m Vence el 20 de febrero.
echo.
echo %ESC%[1;34m--- 🛠️ ENTORNOS DE DESARROLLO (ED) ---%ESC%[0m
echo %ESC%[1;31m[!] VENCIDO%ESC%[0m
echo   • %ESC%[1;31mACTIVIDAD 4%ESC%[0m
echo.
echo %ESC%[1;34m--- 🏗️ PROYECTO INTERMODULAR (PIGS) ---%ESC%[0m
echo %ESC%[1;31m[!] VENCIDO%ESC%[0m
echo   • %ESC%[1;31mDiseño Sistema Informático%ESC%[0m (Venció el 21 de enero)
echo.
echo %ESC%[1;34m--- 🖥️ SISTEMAS INFORMÁTICOS (SI) ---%ESC%[0m
echo %ESC%[1;33m[?] ESTADO INCIERTO%ESC%[0m
echo   • %ESC%[1;37mEntrega Actividad 03:%ESC%[0m Sin fecha de cierre (Abierta 12/01)
echo.
echo %ESC%[1;34m--- 👔 TUTORÍA ---%ESC%[0m
echo %ESC%[1;30m[x] VENCIDO (MUY ANTIGUO)%ESC%[0m
echo   • %ESC%[1;30mCurriculum Vitae%ESC%[0m (Noviembre 2025)
echo.
echo %ESC%[1;35m==================================================%ESC%[0m
echo.

:: Mantiene la ventana abierta
cmd /k