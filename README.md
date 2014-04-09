# Boggle

This is a Boggle board solver written in Scala. It was co-authored by [Paul-Jean](https://github.com/paul-jean) and me during our first week at Hacker School. 

## Notes

We did not implement our own prefix tree (boggle.LetterTree), but the rest of the code is ours.

## Instructions

```bash
boggle $sbt
[info] Loading project definition from /Users/andrea/workspace-scala/boggle/project
[info] Set current project to boggle (in build file:/Users/andrea/workspace-scala/boggle/)
> compile
[info] Compiling 1 Scala source to /Users/andrea/workspace-scala/boggle/target/scala-2.10/classes...
[success] Total time: 6 s, completed Feb 13, 2014 4:47:15 PM
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
