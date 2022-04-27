SCRIPT_START
REQUIRE set_all_speeds.sc
{
NOP

LVAR_INT scplayer, is_run_active
LVAR_FLOAT speed

is_run_active = FALSE
GET_PLAYER_CHAR 0 scplayer

WHILE TRUE
  WAIT 0
  GET_CHAR_SPEED scplayer speed

  IF IS_KEY_PRESSED VK_TAB
  AND IS_KEY_PRESSED VK_KEY_R
    CLEO_CALL toggle_run 0 (scplayer, is_run_active)(is_run_active)

    WHILE IS_KEY_PRESSED VK_KEY_R
    OR IS_KEY_PRESSED VK_TAB
      WAIT 0
    ENDWHILE
  ENDIF

  IF is_run_active = TRUE
    CLEO_CALL set_velocity 0 (scplayer)
  ENDIF
ENDWHILE
}

SCRIPT_END

{
  LVAR_INT player
  LVAR_INT is_active
  
  toggle_run:
  IF is_active = TRUE
    PRINT_FORMATTED_NOW "Deactivated run!" 3000
    WAIT 1500
    is_active = FALSE
  ELSE
    PRINT_FORMATTED_NOW "Activated run!" 3000
    WAIT 1500
    is_active = TRUE
  ENDIF

  CLEO_RETURN 0 is_active
}
