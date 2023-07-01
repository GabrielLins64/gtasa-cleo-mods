SCRIPT_START
{
NOP

LVAR_INT scplayer
GET_PLAYER_CHAR 0 scplayer

WHILE TRUE
  WAIT 0

  IF IS_KEY_PRESSED VK_TAB
  AND IS_KEY_PRESSED VK_KEY_T
  AND IS_KEY_PRESSED VK_KEY_J

    LVAR_FLOAT targetX, targetY, targetZ
    targetX = -377.73
    targetY = -1403.91
    targetZ = -24.94

    SET_CHAR_COORDINATES scplayer targetX targetY targetZ
    PRINT_FORMATTED_NOW "Coordenadas (%i, %i, %i)" 3000 targetX targetY targetZ

    WHILE IS_KEY_PRESSED VK_KEY_J
    OR IS_KEY_PRESSED VK_KEY_T
    OR IS_KEY_PRESSED VK_TAB
      WAIT 0
    ENDWHILE
  ENDIF

ENDWHILE
}

SCRIPT_END