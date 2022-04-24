SCRIPT_START
{
NOP

// While True necessita de ativação nos arquivos
// de configuração do compilador gta3sc
WHILE TRUE
  WAIT 0

  IF IS_KEY_PRESSED VK_KEY_H
  AND IS_KEY_PRESSED VK_TAB
    PRINT_STRING_NOW "Hello World!" 3000

    WHILE IS_KEY_PRESSED VK_KEY_H
    OR IS_KEY_PRESSED VK_TAB
      WAIT 0
    ENDWHILE
  ENDIF

ENDWHILE
}
SCRIPT_END