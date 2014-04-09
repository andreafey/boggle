# Boggle

This is a Boggle board solver written in Scala. It was co-authored by [Paul-Jean](https://github.com/paul-jean) and me during our first week at Hacker School. It can find 1765 words in an evil 4x4 grid!

## Notes

We did not implement our own prefix tree (boggle.LetterTree), but the rest of the code is ours.

## Instructions

```bash
boggle [master *%] $ sbt run
...
[info] Compiling 3 Scala sources to /Users/andrea/workspace-scala/boggle/target/scala-2.10/classes...
[info] Running boggle.RunBoggle
creating dictionary ...
finding words ...
205 words found

board:
feuc
zadr
ibso
wgwt

finding words ...
1765 words found

board:
sers
patg
line
sers
```
