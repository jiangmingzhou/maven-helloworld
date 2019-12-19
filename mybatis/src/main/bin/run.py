#!/usr/bin/python
# -*- coding: UTF-8 -*-
# run application 'helloworld'
# Author: jiangmingzhou

import os, sys

def current_dir():
    file_path = os.path.abspath(__file__)
    return os.path.dirname(file_path)

def main(argv):
    workspace = os.path.abspath(os.path.join(current_dir(), os.path.pardir))
    classpath = (".:%s/lib/*:%s/config:%s/data" % (workspace, workspace, workspace))
    cmd = ("java -cp %s my.zjm.mybatis.HelloWorld" % (classpath))
    print("$$ %s" % cmd)
    os.system(cmd)

if __name__ == "__main__":
   main(sys.argv[1:])
