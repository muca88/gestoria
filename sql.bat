@echo off
sqlcmd -S SIMIMX-BDQA01 -U usrGestoria -P g3st0r14 -i sql\limpiar.sql
pause
exit 

