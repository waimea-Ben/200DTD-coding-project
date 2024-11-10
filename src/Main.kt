import kotlin.random.Random
import java.util.Scanner
import java.util.InputMismatchException

val SPACE = ' '
val SILVER = '○'
val GOLD = '●'


fun main() {
    welcome()
    val scanner = Scanner(System.`in`) // initialise scanner
    var continuePlaying: Boolean

    do {
        var listlen = 20 // set default values for list length and number of X's
        var Numx = 5

        println("Let’s get started by entering your names!")  // name entering

        // Input for Player One
        var ply1name: String
        do {
            print("Player One Name: ")
            ply1name = readln().capitalize()
            if (ply1name.isEmpty()) {
                println("Name cannot be empty. Please enter a valid name.")
            }
        } while (ply1name.isEmpty())

        // Input for Player Two
        var ply2name: String
        do {
            print("Player Two Name: ")
            ply2name = readln().capitalize()

            if (ply2name.isEmpty()||ply1name==ply2name) {
                println("Please enter a valid name.")
            }
        } while (ply2name.isEmpty()||ply1name==ply2name)

        do {
            print("Would you like to customise the size of the game? (Y/N): ")  // option for custom games
            val custom = readln().uppercase()

            if (custom == "Y") {
                println("How many X's?")
                Numx = readln().toInt()
                println("How long would you like this list?")

                do { // verify list is long enough to contain at least the X's and the Coin
                    listlen = readln().toInt()

                    if (listlen < Numx + 1||listlen > 100) {
                        println("Invalid List length, list must accommodate at least the X's and the coin and be no more than 100")
                    }
                }while (listlen < Numx + 1||listlen > 100)
            }

        }while (custom.isEmpty())

        gameLoop(scanner, ply1name, ply2name, Numx, listlen)

        // Ask if the players want to play again
        println("Do you want to play again? (Y/N): ")
        continuePlaying = readln().uppercase() == "Y"

    } while (continuePlaying)
}


fun welcome() {
    println(
        "     OOOOOOOOO      LLLLLLLLLLL              DDDDDDDDDDDDD                         GGGGGGGGGGGGG      OOOOOOOOO      LLLLLLLLLLL              DDDDDDDDDDDDD        \n".yellow() +
                "   OO:::::::::OO    L:::::::::L              D::::::::::::DDD                   GGG::::::::::::G    OO:::::::::OO    L:::::::::L              D::::::::::::DDD     \n".yellow() +
                " OO:::::::::::::OO  L:::::::::L              D:::::::::::::::DD               GG:::::::::::::::G  OO:::::::::::::OO  L:::::::::L              D:::::::::::::::DD   \n".yellow() +
                "O:::::::OOO:::::::O LL:::::::LL              DDD:::::DDDDD:::::D             G:::::GGGGGGGG::::G O:::::::OOO:::::::O LL:::::::LL              DDD:::::DDDDD:::::D  \n".yellow() +
                "O::::::O   O::::::O   L:::::L                  D:::::D    D:::::D           G:::::G       GGGGGG O::::::O   O::::::O   L:::::L                  D:::::D    D:::::D \n".yellow() +
                "O:::::O     O:::::O   L:::::L                  D:::::D     D:::::D         G:::::G               O:::::O     O:::::O   L:::::L                  D:::::D     D:::::D\n".yellow() +
                "O:::::O     O:::::O   L:::::L                  D:::::D     D:::::D         G:::::G               O:::::O     O:::::O   L:::::L                  D:::::D     D:::::D\n".yellow() +
                "O:::::O     O:::::O   L:::::L                  D:::::D     D:::::D         G:::::G    GGGGGGGGGG O:::::O     O:::::O   L:::::L                  D:::::D     D:::::D\n".yellow() +
                "O:::::O     O:::::O   L:::::L                  D:::::D     D:::::D         G:::::G    G::::::::G O:::::O     O:::::O   L:::::L                  D:::::D     D:::::D\n".yellow() +
                "O:::::O     O:::::O   L:::::L                  D:::::D     D:::::D         G:::::G    GGGGG::::G O:::::O     O:::::O   L:::::L                  D:::::D     D:::::D\n".yellow() +
                "O:::::O     O:::::O   L:::::L                  D:::::D     D:::::D         G:::::G        G::::G O:::::O     O:::::O   L:::::L                  D:::::D     D:::::D\n".yellow() +
                "O::::::O   O::::::O   L:::::L         LLLLLL   D:::::D    D:::::D           G:::::G       G::::G O::::::O   O::::::O   L:::::L         LLLLLL   D:::::D    D:::::D \n".yellow() +
                "O:::::::OOO:::::::O LL:::::::LLLLLLLLL:::::L DDD:::::DDDDD:::::D             G:::::GGGGGGGG::::G O:::::::OOO:::::::O LL:::::::LLLLLLLLL:::::L DDD:::::DDDDD:::::D  \n".yellow() +
                " OO:::::::::::::OO  L::::::::::::::::::::::L D:::::::::::::::DD               GG:::::::::::::::G  OO:::::::::::::OO  L::::::::::::::::::::::L D:::::::::::::::DD   \n".yellow() +
                "   OO:::::::::OO    L::::::::::::::::::::::L D::::::::::::DDD                   GGG::::::GGG:::G    OO:::::::::OO    L::::::::::::::::::::::L D::::::::::::DDD     \n".yellow() +
                "     OOOOOOOOO      LLLLLLLLLLLLLLLLLLLLLLLL DDDDDDDDDDDDD                         GGGGGG   GGGG      OOOOOOOOO      LLLLLLLLLLLLLLLLLLLLLLLL DDDDDDDDDDDDD        \n".yellow())
    println("welcome to old gold!")
    while (true){
        print("Is this your first time? (Y/N)") // instructions opt in/out
        val playb4 = readln().toUpperCase()

        if (playb4 == "N") {
            println("Cool!, i wont bore you with the rules then.")
            break
        } else if (playb4 == "Y") {
            println("Okay, Let me fill you in on how this works.") // instructions
            println()
            println("How to Play: ")
            println("The grid and coins are randomly placed, with one gold coin (" + "G".yellow() + ") and several normal coins (" + "X".green() + ")")
            println("The red X's cannot be selcted as they have no valid moves.")
            println("On your turn, you can either:")
            println("Move a coin left (without jumping or sharing squares) or remove a coin if it's in position 0 (the far-left square). ")
            println("The player who removes the gold coin from position 0 wins!")
            println()
            break
        }}


    return
}

// Generates a random string of length 20 with 5 SILVERs and 1 GOLD
fun generateString(listlen: Int, Numx: Int): MutableList<Char> {
    val result = MutableList(listlen) { SPACE } // Start with '0' in all positions
    var xCount = 0
    var gPlaced = false

    // Place SILVER in random positions
    while (xCount < Numx) {
        val index = Random.nextInt(listlen)
        if (result[index] == SPACE) {
            result[index] = SILVER
            xCount++
        }
    }

    // Place GOLD in a random position
    while (!gPlaced) {
        val index = Random.nextInt(listlen)
        if (result[index] == SPACE) { // Only place G where there's no X
            result[index] = GOLD
            gPlaced = true
        }
    }

    return result // Ensure this returns MutableList<Char>
}

// Prints the result in a formatted list style with rounded corners and indices
fun listable(result: List<Char>) {
    // Top border with rounded corners
    print("╭─".red())
    print("──┬─".repeat(result.size - 1).red())
    println("──╮".red())
    // Top row with indices
    for (i in result.indices) {
        print("│ ".yellow())
        print("%-2d".format(i)) // Print each index with a width of 2 for proper spacing
    }
    println("│".yellow())

    // Middle divider
    print("├".green())
    print("───┼".repeat(result.size - 1).green())
    print("───┤".green())
    println()

    // Bottom row with content
    for (i in result.indices) {
        print("│ ".cyan())
        when (result[i]) {
            SILVER -> {
                // Check if there is an SILVER to the left
                if (i > 0 && (result[i - 1] == SILVER || result[i - 1] == GOLD)) {
                    print("%-2s".format(result[i].toString()).red())
                } else {3
                    print("%-2s".format(result[i].toString()).green())
                }
            }
            SPACE -> print("%-2s".format(result[i].toString()).grey())
            GOLD -> print("%-2s".format(result[i].toString()).yellow())
        }
    }
    println("│".cyan())

    // Bottom border with rounded corners
    print("╰─".blue())
    print("──┴─".repeat(result.size - 1).blue())
    println("──╯".blue())
}

// Moves the selected token (SILVER or GOLD) to the specified index if possible
fun moveToken(board: MutableList<Char>, fromIndex: Int, toIndex: Int): Boolean {
    // Check if the fromIndex is valid
    if (fromIndex < 0 || fromIndex >= board.size || board[fromIndex] == SPACE) {
        println("Invalid move. Choose a valid token to move.")
        return false
    }

    // Check if the destination index is valid and less than fromIndex (move left)
    if (toIndex < 0 || toIndex >= board.size || toIndex >= fromIndex) {
        println("Invalid destination index! You can only move left.")
        return false
    }

    // Check if the destination index is empty
    if (board[toIndex] != SPACE) {
        println("Cannot move to that position! It is already occupied.")
        return false
    }

    // Check for obstacles in the path when moving left
    for (i in (toIndex + 1)..<fromIndex) {
        if (board[i] != SPACE) {
            println("Cannot jump over other tokens!")
            return false
        }
    }

    // Move the token
    board[toIndex] = board[fromIndex] // Move the token to the new position
    board[fromIndex] = SPACE // Replace the old position with SPACE
    return true
}

// Handles player input and validates token selection
fun handleTokenChoice(scanner: Scanner, board: MutableList<Char>): Int {
    var tokenChoice: Int
    while (true) {
        print("Enter the index of the token (X or G) you want to move or remove, or -1 to quit: ")

        try {
            tokenChoice = scanner.nextInt()

            // Exit the game if -1 is chosen
            if (tokenChoice == -1) {
                println("Exiting the game.")
                return -1
            }

            // Check if the chosen index is valid
            if (tokenChoice in board.indices) {
                // Check if the selected token is GOLD or SILVER
                if (board[tokenChoice] == SILVER) {
                    // Check if there is another SILVER to the left
                    if (tokenChoice > 0 && (board[tokenChoice - 1] == SILVER || board[tokenChoice - 1] == GOLD)){

                        println("You cannot select this token because it has no valid moves.")
                        continue // Prompt the player to select again
                    }
                } else if (board[tokenChoice] == GOLD) {
                    return tokenChoice // Allow selection of GOLD
                }

                return tokenChoice // Valid choice for SILVER
            } else {
                println("Invalid choice. Please select a valid token index.")
            }
        } catch (e: InputMismatchException) {
            // Handle non-numeric input
            println("Invalid input. Please enter a valid number.")
            scanner.next() // Consume the invalid input to avoid an infinite loop
        }
    }
}

// Handles destination index input and moves the token
fun handleMove(scanner: Scanner, board: MutableList<Char>, tokenChoice: Int): Boolean {
    print("Enter the index you want to move the token to: ")
    val destinationIndex: Int = scanner.nextInt()

    // Attempt to move the token
    return moveToken(board, tokenChoice, destinationIndex)
}

// Checks if the token at index 0 should be removed
fun handleRemoveToken(board: MutableList<Char>, scanner: Scanner, currentPlayer: String): Boolean {
    return if (board[0] == GOLD) {
        println("Congratulations $currentPlayer! You have removed the Coin and won the game!".green())
        true // Game ends
    } else {
        board[0] = SPACE // Remove the token
        println("Token at index 0 has been removed.")
        false
    }
}

// Main game loop
fun gameLoop(scanner: Scanner, ply1name: String, ply2name: String, Numx: Int, listlen: Int) {
    val board = generateString(listlen, Numx) // Generate the board
    var currentPlayer = ply1name // Start with Player 1
    var gameWon = false

    while (!gameWon) {
        var validMove = false

        while (!validMove) {

            // Display the board
            listable(board)

            // Indicate current player's turn
            if (currentPlayer == ply1name) {
                println("$currentPlayer's turn.".bgRed().black())
            } else {
                println("$currentPlayer's turn.".bgBlue().black())
            }

            // Get the player's token choice
            val tokenChoice = handleTokenChoice(scanner, board)
            if (tokenChoice == -1) return // Exit the game if -1 is chosen

            // Handle special case of removing a token from index 0
            if (tokenChoice == 0) {
                gameWon = handleRemoveToken(board, scanner, currentPlayer)
                if (gameWon) return
                validMove = true
            } else {
                // Handle the move
                validMove = handleMove(scanner, board, tokenChoice)
            }
        }

        // Switch players after a valid move
        currentPlayer = if (currentPlayer == ply1name) ply2name else ply1name
    }
}