# Ready-to-use examples of dkpro-core components and pipelines

This package, *dkpro-core-examples*, demonstrates the use of [DKPro Core](http://dkpro.github.io/) components, such as readers, annotators, and writers.
Each module in this project refers to a DKPro core component, providing a simple pipeline that is
usable as is.

This branch uses DKPro Core version 1.9.0-SNAPSHOT.

This Repository adapts the code to test the dkpro pipline command line tool. 


## This repository is only for testing purposes of a dkpro web service automation tool 
## For examples of DKPRO use the forked repository
## Content 

So far, *dkpro-core-examples* comprises the following examples:

* **nameannotation-asl**: a dictionary-based name annotator that uses a custom annotation type. 
* **lda-asl**: pipelines to demonstrates how to estimate an LDA model and how to use it to infer topic proportions
in documents. Note that the API and hence the examples have changed in v1.9.x.
* **tokenizedwriter-asl**: demonstrates the `TokenizedTextWriter` which writes all tokens from all documents separated
by whitespaces, one sentence per line; can be used to prepare data for external tools such as Word2Vec. 
* **stanfordcorecomponents-gpl**: demonstrates the usage of the Stanford Core NLP tools; mind that they are
 GPL-licensed!
* **wordembeddings-asl**: a pipeline that shows how to generate [word embeddings](https://en.wikipedia.org/wiki/Word_embedding) from a custom corpus and how to use them with an annotator.
* **phraseannotator-asl**: pipelines demonstrating the usage of the classes `FrequencyCounter` and `PhraseAnnotator` to detect lexical phrases in a frequency-based manner.

## Contact

In case you have any questions or problems with these examples, we are happy to help you -- this is a tutorial project, so we are glad to improve things and make life easier for both new and experienced [DKPro Core](http://dkpro.github.io/) users.
The easiest ways to get in touch are the [DKPro Core mailing lists](https://dkpro.github.io/dkpro-core/pages/mailinglists/) or to [submit an issue](https://github.com/dkpro/dkpro-core-examples/issues).
