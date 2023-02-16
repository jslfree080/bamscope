# bamscope
![Build Status](https://github.com/jslfree080/bamscope/actions/workflows/tests.yml/badge.svg?branch=main)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/jslfree080/bamscope/blob/main/LICENSE)

A command line tool (in Kotlin/JVM) for intuitively visualizing BAM alignments.

<img alt="demonstration" src="https://github.com/jslfree080/jslfree080/blob/main/example2.png" width=600>

## Interpretation of Output Image

The images produced display the alignment of the bases using colored blocks. The opacity of each block reflects the quality score of the base, with blocks valued near 1 displayed for high-quality scores near 40 and those valued near 0 for low-quality scores close to 0. The strandedness of each read's alignment is indicated in both the leftmost and rightmost columns, where '→' indicates a forward strand alignment and '←' indicates a reverse strand alignment.

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
      <chrPos>              Input chromosomal position       ex) (chr)N:XXXXXXXX
                                 or path to a VCF file.         or path/to/x.vcf
      <bamPath>             Path to an indexed BAM file.       ex) path/to/x.bam
     
Options:
  -f, --format=<format>     File format of an output image.         default) png
  -h, --help                Show this help message and exit.
  -o, --outPath=<outPath>   Path to an output image.                  default) .
  -r, --refPath=<refPath>   Path to a reference FASTA.  ex) path/to/x.fasta(.fa)
  -s, --sPath=<sPath>       Path to the samtools.    ex) /usr/local/bin/samtools
  -w, --width=<width>       Width of start to interest position.     default) 50
```

* Example usage for a specific position:
```
    java -jar build/libs/bamscope.jar 18:53254446 ~/Downloads/x.bam -r ~/Downloads/x.fasta -o ~/Desktop/
```

* Example usage with VCF file (⚠️ This option may be computationally intensive):
```
    java -jar build/libs/bamscope.jar ~/Desktop/x.vcf ~/Downloads/x.bam -r ~/Downloads/x.fasta -o ~/Desktop/
```

## License

Code and documentation released under the [MIT license](https://github.com/jslfree080/bamscope/blob/master/LICENSE).
