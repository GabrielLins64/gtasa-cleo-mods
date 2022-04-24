SCRIPT_START
{
NOP

LVAR_INT model

model = 400

mainloop:
WAIT 0

IF IS_KEY_PRESSED VK_KEY_U
  IF model < 611
    model += 1
    PRINT_FORMATTED_NOW "Modelo de carro %i selecionado" 3000 model
    WHILE IS_KEY_PRESSED VK_KEY_U // aguardar enquanto ainda estou segurando a tecla U
      WAIT 0
    ENDWHILE
  ELSE
    PRINT_FORMATTED_NOW "Nao ha mais modelos alem deste (611)" 3000
  ENDIF
ENDIF

IF IS_KEY_PRESSED VK_KEY_J
  IF model > 400
    model -= 1
    PRINT_FORMATTED_NOW "Modelo de carro %i selecionado" 3000 model
    WHILE IS_KEY_PRESSED VK_KEY_J
      WAIT 0
    ENDWHILE
  ELSE
    PRINT_FORMATTED_NOW "Nao ha mais modelos alem deste (400)" 3000
  ENDIF
ENDIF

IF IS_KEY_PRESSED VK_KEY_G
AND IS_KEY_PRESSED VK_TAB
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