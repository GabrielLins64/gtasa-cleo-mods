SCRIPT_START
{
NOP

LVAR_INT scplayer
GET_PLAYER_CHAR 0 scplayer

WHILE TRUE
  WAIT 0

  IF IS_KEY_PRESSED VK_KEY_T
  AND IS_KEY_PRESSED VK_KEY_H

    LVAR_FLOAT targetX, targetY, targetZ
    GET_TARGET_BLIP_COORDS targetX targetY targetZ

    SET_CHAR_COORDINATES scplayer targetX targetY targetZ
    PRINT_FORMATTED_NOW "Coordenadas (%i, %i, %i)" 3000 targetX targetY targetZ

    WHILE IS_KEY_PRESSED VK_KEY_H
    OR IS_KEY_PRESSED VK_KEY_T
      WAIT 0
    ENDWHILE
  ENDIF

ENDWHILE
}

SCRIPT_END