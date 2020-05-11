# Apache Kafka Benchmark

# Objective

Automatically create Apache Kafka topics and produce messages for a configurable period of time and at a configurable rate. Details can be found in `benchmark-runner.yml`.

# Setup

You need to adapt a few files to your environment, namely:

- tools/commons/commons.conf
- tools/configuration/hosts
- tools/configuration/monitoring/*
- tools/datasender/datasender.conf

This project is designed to be executed on a linux machine by user
`benchmarker`, who cloned this repository into `~/Benchmarks/`. 

Build it using `sbt assembly`. 

# Run

For directly executing the benchmark via ansible, you have to change to 
directory `tools/configuration` and execute, e.g., 
`ansible-playbook -vvvv plays/benchmark-runner.yml`.
