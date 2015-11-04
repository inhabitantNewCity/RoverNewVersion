package netcracker.intensive.rover.programmable;

/**
 * Это исключение должно быть непроверяемым - оно происходит, когда возникает ошибка чтения файла с программой для ровера.
 * Дальнейшее выполнение программы становится невозможным. Исключение должно содержать информации о породившем его исключении.
 */
public class RoverCommandParserException extends RuntimeException{
}
