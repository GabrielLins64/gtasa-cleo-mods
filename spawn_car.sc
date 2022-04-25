SCRIPT_START
{
NOP

CONST_INT MAX_MODEL 611
CONST_INT MIN_MODEL 400

LVAR_INT model
LVAR_INT scplayer

GET_PLAYER_CHAR 0 scplayer

model = 400

mainloop:
WAIT 0

IF IS_KEY_PRESSED VK_KEY_U
  IF model < MAX_MODEL
    model += 1
    PRINT_FORMATTED_NOW "Modelo de carro %i selecionado" 3000 model
    WHILE IS_KEY_PRESSED VK_KEY_U // aguardar enquanto ainda estou segurando a tecla U
      WAIT 0
    ENDWHILE
  ELSE
    PRINT_FORMATTED_NOW "Nao ha mais modelos alem deste (%i)" 3000 model
  ENDIF
ENDIF

IF IS_KEY_PRESSED VK_KEY_J
  IF model > MIN_MODEL
    model -= 1
    PRINT_FORMATTED_NOW "Modelo de carro %i selecionado" 3000 model
    WHILE IS_KEY_PRESSED VK_KEY_J
      WAIT 0
    ENDWHILE
  ELSE
    PRINT_FORMATTED_NOW "Nao ha mais modelos alem deste (%i)" 3000 model
  ENDIF
ENDIF

IF IS_KEY_PRESSED VK_KEY_G
AND IS_KEY_PRESSED VK_TAB
AND NOT IS_CHAR_IN_ANY_CAR scplayer
  SPAWN_VEHICLE_BY_CHEATING model
  PRINT_FORMATTED_NOW "Carro %i spawnado!" 3000 model

  WHILE IS_KEY_PRESSED VK_KEY_G
  OR IS_KEY_PRESSED VK_TAB
    WAIT 0
  ENDWHILE
ENDIF

GOTO mainloop
}
SCRIPT_END