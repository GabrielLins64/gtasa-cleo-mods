SCRIPT_START
{
NOP

LVAR_INT scplayer
GET_PLAYER_CHAR 0 scplayer

WHILE TRUE
  WAIT 0

  IF IS_KEY_PRESSED VK_TAB
  AND IS_KEY_PRESSED VK_KEY_I
  AND IS_KEY_PRESSED VK_KEY_J

    LVAR_FLOAT targetX, targetY, targetZ
    targetX = -381.10
    targetY = -1426.96
    targetZ = 26.0

    SET_CHAR_COORDINATES scplayer targetX targetY targetZ
    SET_CHAR_HEADING scplayer 270.0
    PRINT_FORMATTED_NOW "Coordenadas (%i, %i, %i)" 3000 targetX targetY targetZ

    WHILE IS_KEY_PRESSED VK_KEY_J
    OR IS_KEY_PRESSED VK_KEY_I
    OR IS_KEY_PRESSED VK_TAB
      WAIT 0
    ENDWHILE
  ENDIF

ENDWHILE
}

SCRIPT_END