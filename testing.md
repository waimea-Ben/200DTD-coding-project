# Test Plan and Evidence / Results of Testing

## Game Description

The project involves the programming of a two-player game.

"Old Gold" is a strategic two-player game where each player tries to move coins across a board to achieve a specific objective: removing the gold coin from the far-left position of the board. Players take turns moving or removing tokens, which include silver coins and one gold coin. The game requires careful planning, as certain moves are restricted based on the arrangement of the tokens on the board.
### Game Features and Rules

The game has the following features and/or rules:
Rules:
 - coins can  only move left
 - coins cannot jump other coins
 - coins with token to their left have no valid moves and cannot be selected
Features:
 - two player name input for player customization
 - randomized board generation to ensure no two games are the same.
 - customizable board size, including number of tokens and length.
 - automatic move validation to ensure no breakages

---

## Test Plan

The following game features / functionality and player actions will need to be tested:

- Player name input validation for both players.
- Customization of game length and number of SILVER (X) tokens.
- Generation and layout of the board, including placement of SILVER and GOLD tokens.
- Validation of player token selection and destination for moves.
- Handling of token removal at index 0, including win conditions.
- Switching between players after each valid move.
- Option to play again after each game.

The following tests will be run against the completed game. The tests should result in the expected outcomes shown.


### Player Name Input Validation
Ensure the game prompts users to enter valid names for both players and verifies unique names are entered.

#### Test Data / Actions to Use
Attempt to enter an empty name.
Enter the same name for both players.
#### Expected Outcome
Empty names are rejected, and the user is prompted to enter a valid name.
Duplicate names are rejected, and a prompt requests a different name for Player Two.




### Game Customization for SILVER Tokens and Board Length
Test the customization option to set the number of SILVER tokens and the board length, ensuring values are within valid ranges.

#### Test Data / Actions to Use
Choose a number of SILVER tokens less than or equal to 5.
Choose a board length greater than or equal to (Numx + 1) and less than or equal to 100.
Try invalid numbers for both SILVER tokens and board length.
#### Expected Outcome
Valid inputs set the number of SILVER tokens and board length.
Invalid values prompt an error message, requiring input within valid ranges.




### Token Selection and Movement Validation
Verify that only valid tokens (SILVER or GOLD) can be selected, and test movement options to ensure players can only move left to an open space.

#### Test Data / Actions to Use
Attempt to select an invalid token (e.g., an empty space).
Try to move a token to an occupied space or an index to the right.
Attempt to jump over other tokens.
#### Expected Outcome
The game does not allow selection of invalid tokens and prompts for valid token choices.
Only moves to open spaces on the left are allowed; jumps and rightward moves are blocked.



### Token Removal and Win Condition at Index 0
Test the handling of token removal at index 0 and verify that a win is declared when the GOLD token is removed.

#### Test Data / Actions to Use
Move a SILVER token to index 0 and remove it.
Move the GOLD token to index 0 and remove it.
#### Expected Outcome
SILVER token removal from index 0 triggers a "token removed" message without ending the game.
GOLD token removal at index 0 declares the current player as the winner, ending the game.



### Player Switching
Ensure players alternate turns after each valid move, with the appropriate prompt displayed.

#### Test Data / Actions to Use
Make a valid move with Player One.
Confirm Player Two’s turn begins.
Repeat the process for multiple turns.
#### Expected Outcome
After each valid move, the game alternates turns between Player One and Player Two as expected.



### Replay Option
Verify that players can restart the game and play multiple rounds without issues.

#### Test Data / Actions to Use
Play a complete game, then choose to play again when prompted.
Repeat the process for multiple games in succession.
#### Expected Outcome
After each completed game, players are prompted to play again. Choosing "Yes" restarts the game with a fresh board; choosing "No" exits the program.


---


## Evidence / Results of Testing

### Player Name Input Validation

ACTUAL RESULTS OF TESTING SHOWN HERE
https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/bemartin_waimea_school_nz/ERbM-vpQh-REtHWbOX5RIL4BNfSYM_Q9MW2GgxhCBNTf6Q?e=rVhhqN&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D



### Game Customization for SILVER Tokens and Board Length

ACTUAL RESULTS OF TESTING SHOWN HERE
https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/bemartin_waimea_school_nz/ESD4zk2WfqdPnOwMwuJzHrUBJrMn7ttRH4h5a9G0X499_Q?e=qK3sDm&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D



### Token Selection and Movement Validation

ACTUAL RESULTS OF TESTING SHOWN HERE
https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/bemartin_waimea_school_nz/EYEmjmVZY2NNiJSYYpNAtuMB8hQZr_luzrHuXC05d7TMJQ?e=nrSZdA&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D


### Token Removal and Win Condition at Index 0

ACTUAL RESULTS OF TESTING SHOWN HERE
https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/bemartin_waimea_school_nz/EYEmjmVZY2NNiJSYYpNAtuMB8hQZr_luzrHuXC05d7TMJQ?e=nrSZdA&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D



### Player Switching

ACTUAL RESULTS OF TESTING SHOWN HERE
https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/bemartin_waimea_school_nz/EYEmjmVZY2NNiJSYYpNAtuMB8hQZr_luzrHuXC05d7TMJQ?e=nrSZdA&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D


### Replay Option

ACTUAL RESULTS OF TESTING SHOWN HERE
https://mywaimeaschool-my.sharepoint.com/:v:/g/personal/bemartin_waimea_school_nz/EYEmjmVZY2NNiJSYYpNAtuMB8hQZr_luzrHuXC05d7TMJQ?e=nrSZdA&nav=eyJyZWZlcnJhbEluZm8iOnsicmVmZXJyYWxBcHAiOiJTdHJlYW1XZWJBcHAiLCJyZWZlcnJhbFZpZXciOiJTaGFyZURpYWxvZy1MaW5rIiwicmVmZXJyYWxBcHBQbGF0Zm9ybSI6IldlYiIsInJlZmVycmFsTW9kZSI6InZpZXcifX0%3D
