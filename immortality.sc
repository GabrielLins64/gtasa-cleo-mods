SCRIPT_START
{
NOP

LVAR_INT scplayer
LVAR_INT is_active

is_active = FALSE
GET_PLAYER_CHAR 0 scplayer

mainloop:
WAIT 0

IF IS_KEY_PRESSED VK_TAB
AND IS_KEY_PRESSED VK_KEY_I
AND IS_KEY_PRESSED VK_KEY_M

  CLEO_CALL toggle_immortality 0 (scplayer, is_active)(is_active)

  WHILE IS_KEY_PRESSED VK_TAB
  OR IS_KEY_PRESSED VK_KEY_I
  OR IS_KEY_PRESSED VK_KEY_M
    WAIT 0
  ENDWHILE
ENDIF

GOTO mainloop
}
SCRIPT_END

{
  LVAR_INT player
  LVAR_INT is_active

  toggle_immortality:
  IF is_active = TRUE
    SET_CHAR_ONLY_DAMAGED_BY_PLAYER player, FALSE
    is_active = FALSE
    PRINT_FORMATTED_NOW "Immortality deactivated" 2000
  ELSE
    SET_CHAR_ONLY_DAMAGED_BY_PLAYER player, TRUE
    is_active = TRUE
    PRINT_FORMATTED_NOW "Immortality activated" 2000
  ENDIF

  CLEO_RETURN 0 is_active
}
