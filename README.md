<h1>Quiz 2 DAA (Minesweeper Game)</h1> 

### Contributions on Project 

Nama | NRP |
--------- | --------- | 
M. Armand Giovani | 5025211054 |
Christian Kevin Emor | 5025211153 |
Hanafi Satriyo Utomo Setiawan | 5025211195 |

## MINESWEEPER GAMES
In this assignment, we have been tasked with developing a minesweeper game, which involves creating a digital application that simulates the classic puzzle game where players uncover hidden mines on a grid-based playing field. Our objective is to design and implement the game mechanics, including generating a random minefield, placing mines strategically, and incorporating user interactions such as revealing cells, flagging potential mines, and calculating the number of adjacent mines. Throughout the development process, we will also ensure an intuitive user interface, smooth gameplay experience, and appropriate visual and audio elements to enhance engagement and enjoyment for players.
![image1](https://github.com/VanGarman21/Minesweeper/assets/97864068/1a30a374-4486-458d-a62f-2336aa044c7c)

Uses a recursion algorithm (DFS - Depth-First Search) to reveal connected cells in the game Minesweeper. This algorithm is used in the uncoverSurroundingCellsDFS method which unravels cells and iteratively explores connected cells that have no mines around them. This algorithm utilizes the stack to track the cells to be checked next. In addition, this code also uses a random algorithm (Random) to place mines in the placeMines method.

### The algorithm used in this code includes the following steps:
1. Initialization: It sets up the game window, creates the necessary arrays, and initializes variables.
2. Placing Mines: Randomly selects and places 10 mines on the grid.
3. Counting Surrounding Mines: Calculates the number of mines adjacent to each cell and stores the count in the surroundingMines array.
4. Cell Uncovering: Handles the logic when a cell is uncovered by the player. If the cell contains a mine, the player loses the game. Otherwise, the number of surrounding mines is displayed on the button, and if the cell has no surrounding mines, the algorithm recursively uncovers adjacent cells using Depth-First Search (DFS).
5. DFS for Uncovering Surrounding Cells: Uses a stack to perform DFS on neighboring cells and uncover them until cells with surrounding mines are encountered.
6. Win or Lose: Displays a message box indicating whether the player has won or lost the game and exits the program accordingly

## Conclusion
In conclusion, our team succeeded in developing a Minesweeper game that incorporates various algorithms taught in our lectures. The game provides an interactive and engaging experience for players while demonstrating the application of key algorithms such as Depth-First Search (DFS) and randomization.During the implementation process, we faced the challenge of managing game state and ensuring optimal performance. However, by leveraging our understanding of the DFS algorithm and leveraging randomization techniques, we managed to overcome these challenges and achieve a game that is both functional and fun.

Game evaluation and analysis revealed satisfactory performance in terms of uncovering cells and dealing with game logic. The DFS algorithm efficiently finds neighboring cells without mines in the vicinity, minimizing the amount of user interaction required. Additionally, the randomization algorithm facilitates fair placement of mines, adding an element of unpredictability to every game session.Overall, this project gave us hands-on experience in applying algorithmic concepts to real-world problems. This strengthens our programming skills, fosters collaboration within our team, and deepens our understanding of algorithms and their practical applications.

We are grateful for the opportunity to work on this project and the knowledge gained during its development. It served as a valuable learning experience, allowing us to bridge the gap between theoretical knowledge and practical implementation.

## THANKYOU
![1_989-aZG8J-PcM7okXSebEA](https://github.com/VanGarman21/Minesweeper/assets/97864068/3561ab9e-ec26-401f-9f9c-43219fb1ab1f)

