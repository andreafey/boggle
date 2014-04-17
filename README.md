[![Build Status](https://travis-ci.org/andreafey/boggle.svg)](https://travis-ci.org/andreafey/boggle)

# Boggle

This is a Boggle board solver written in Scala. [Paul-Jean](https://github.com/paul-jean) and I co-authored it during our first week at Hacker School. It can find 1765 words in an evil 4x4 grid!

## Notes

The specific boards to search are hard coded into `boggle.RunBoggle`, but you could write your own runner. We did not originally 
implement our own PrefixTrie, but I have since added a dependency on the PrefixTrie I developed for my
[phonebook](https://github.com/andreafey/phonebook) application.

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
