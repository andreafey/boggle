# Boggle

Solver for Boggle boards, written in Scala.

## Instructions

Build the solver using the scala build tool (sbt):

```bash
boggle $sbt
[info] Loading project definition from /Users/andrea/workspace-scala/boggle/project
[info] Set current project to boggle (in build file:/Users/andrea/workspace-scala/boggle/)
> compile
[info] Compiling 1 Scala source to /Users/andrea/workspace-scala/boggle/target/scala-2.10/classes...
[success] Total time: 6 s, completed Feb 13, 2014 4:47:15 PM
```

Run the solver on the board (currently hard-coded in the main method):

```bash
> run
[info] Running boggle.RunBoggle
creating dictionary ...
finding words ...
words found:
feud
feu
...
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
