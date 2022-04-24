SCRIPT_START
{
NOP

LVAR_FLOAT posX
LVAR_FLOAT movX
posX = 0.0
movX = 5.0

main_loop:
WAIT 0

posX +=@ movX
IF posX > 640.0
OR posX < 0.0
  movX *= -1.0
ENDIF

DRAW_RECT (posX 124.0) (20.0 20.0) (255 0 0 255)

USE_TEXT_COMMANDS 0
GOTO main_loop
}
SCRIPT_END