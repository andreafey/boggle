# Boggle

Solver for Boggle boards written in Scala

## Instructions

Construct a Board with a List[List[Char]]

```scala
val grid = List(
  List('f', 'e', 'u', 'c'),
  List('z', 'a', 'd', 'r'),
  List('i', 'b', 's', 'o'),
  List('w', 'g', 'w', 't')) 
val board = new Board(grid)
```
From a dictionary file build a LetterTree adding $ to the end of each word

```scala
val dict = new LetterTree()
for (line <- Source.fromFile("/Users/andrea/workspace-scala/boggle/src/main/resources/dictionary.txt").getLines())
  dict.addWord(line.toLowerCase() + '$')
```
Find the words
```scala
RunBoggle.findAndPrintWords(board, dictionary)
```
``` bash
...
torc
torsade
tor
tow
to
two
t
168 words found

board:
feuc
zadr
ibso
wgwt
```
