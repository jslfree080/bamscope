# bamscope
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/jslfree080/bamscope/blob/main/LICENSE)

<img alt="demonstration" src="https://github.com/jslfree080/jslfree080/blob/main/example2.png" width=550>

A command line tool (in Kotlin/JVM) for visualizing BAM alignments.

## Prerequisites

Bamscope requires **Java 11** or later versions to build and run.

Also, [samtools](https://github.com/samtools/samtools) should be pre-installed to support accessing file formats such as BAM and FASTA.

## Building

* Clone the repo:
```
    git clone https://github.com/jslfree080/bamscope.git
    cd bamscope/
```

* Build an executable Bamscope jar with all dependencies packaged:
```
    ./gradlew build
```

## Usage

### Command line

The resulting jar will be in `build/libs`.

```
Usage: java -jar build/libs/bamscope.jar <chrPos> <bamPath> [options]

Parameters:
      <chrPos>              Input chromosomal position.      ex) (chr)N:XXXXXXXX
      <bamPath>             Path to an indexed bam file.       ex) path/to/x.bam
     
Options:
  -f, --format=<format>     File format of an output image.         default) png
  -h, --help                Show this help message and exit.
  -o, --outPath=<outPath>   Path to an output image.                  default) .
  -r, --refPath=<refPath>   Path to a reference fasta.       ex) path/to/x.fasta
  -s, --sPath=<sPath>       Path to the samtools.    ex) /usr/local/bin/samtools
  -w, --width=<width>       Width of start to interest position.     default) 50
```

* Example usage:
```
    java -jar build/libs/bamscope.jar 18:53254446 ~/Downloads/x.bam -r ~/Downloads/x.fasta -o ~/Desktop/
```

## License

Code and documentation released under the [MIT license](https://github.com/jslfree080/bamscope/blob/master/LICENSE).
