SCRIPT_START
{
NOP

LVAR_INT scplayer
LVAR_INT is_flying
LVAR_FLOAT playerX, playerY, playerZ
LVAR_FLOAT angle, cos, sin, speed

GET_PLAYER_CHAR 0 scplayer
is_flying = FALSE
speed = 5.0

WHILE TRUE
  WAIT 0

  IF IS_KEY_PRESSED VK_TAB
  AND IS_KEY_PRESSED VK_KEY_Y
  AND IS_CHAR_ON_FOOT scplayer

    IF is_flying = TRUE
      FREEZE_CHAR_POSITION scplayer FALSE
      is_flying = FALSE
    ELSE
      FREEZE_CHAR_POSITION scplayer TRUE
      is_flying = TRUE

      GET_CHAR_HEADING scplayer angle
      angle += 90.0
      COS angle (cos)
      SIN angle (sin)
      cos *= speed
      sin *= speed
    ENDIF

    WHILE IS_KEY_PRESSED VK_KEY_H
    OR IS_KEY_PRESSED VK_TAB
      WAIT 0
    ENDWHILE
  ENDIF

  IF is_flying = TRUE
    // Front
    IF IS_KEY_PRESSED VK_KEY_W
      GET_CHAR_COORDINATES scplayer playerX playerY playerZ
      playerX += cos
      playerY += sin
      playerZ -= 1.0
      SET_CHAR_COORDINATES scplayer playerX playerY playerZ
    
      WHILE IS_KEY_PRESSED VK_KEY_W
        WAIT 0
      ENDWHILE
    ENDIF

    // Back
    IF IS_KEY_PRESSED VK_KEY_S
      GET_CHAR_COORDINATES scplayer playerX playerY playerZ
      playerX -= cos
      playerY -= sin
      playerZ -= 1.0
      SET_CHAR_COORDINATES scplayer playerX playerY playerZ
    
      WHILE IS_KEY_PRESSED VK_KEY_S
        WAIT 0
      ENDWHILE
    ENDIF

    // Left
    IF IS_KEY_PRESSED VK_KEY_A
      GET_CHAR_COORDINATES scplayer playerX playerY playerZ
      playerX -= sin
      playerY += cos
      playerZ -= 1.0
      SET_CHAR_COORDINATES scplayer playerX playerY playerZ
    
      WHILE IS_KEY_PRESSED VK_KEY_A
        WAIT 0
      ENDWHILE
    ENDIF

    // Right
    IF IS_KEY_PRESSED VK_KEY_D
      GET_CHAR_COORDINATES scplayer playerX playerY playerZ
      playerX += sin
      playerY -= cos
      playerZ -= 1.0
      SET_CHAR_COORDINATES scplayer playerX playerY playerZ
    
      WHILE IS_KEY_PRESSED VK_KEY_D
        WAIT 0
      ENDWHILE
    ENDIF

    // Up
    IF IS_KEY_PRESSED VK_SPACE
      GET_CHAR_COORDINATES scplayer playerX playerY playerZ
      playerZ += 1.0
      SET_CHAR_COORDINATES scplayer playerX playerY playerZ

      WHILE IS_KEY_PRESSED VK_SPACE
        WAIT 0
      ENDWHILE
    ENDIF

    // Super Up
    IF IS_KEY_PRESSED VK_KEY_U
      GET_CHAR_COORDINATES scplayer playerX playerY playerZ
      playerZ += 5.0
      SET_CHAR_COORDINATES scplayer playerX playerY playerZ

      WHILE IS_KEY_PRESSED VK_KEY_U
        WAIT 0
      ENDWHILE
    ENDIF

    // Down
    IF IS_KEY_PRESSED VK_LCONTROL
      GET_CHAR_COORDINATES scplayer playerX playerY playerZ
      playerZ -= 3.0
      SET_CHAR_COORDINATES scplayer playerX playerY playerZ

      WHILE IS_KEY_PRESSED VK_LCONTROL
        WAIT 0
      ENDWHILE
    ENDIF

    // Super Down
    IF IS_KEY_PRESSED VK_KEY_J
      GET_CHAR_COORDINATES scplayer playerX playerY playerZ
      playerZ -= 7.0
      SET_CHAR_COORDINATES scplayer playerX playerY playerZ

      WHILE IS_KEY_PRESSED VK_KEY_J
        WAIT 0
      ENDWHILE
    ENDIF

    GET_CHAR_COORDINATES scplayer playerX playerY playerZ
    PRINT_FORMATTED_NOW "X: %.2f Y: %.2f Z: %.2f" 1000 playerX playerY playerZ
  ENDIF

ENDWHILE
}

SCRIPT_END