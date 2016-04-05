'__author__'=='deepak Singh Mehta(learning Elasticsearch :) ) '


from elasticsearch import Elasticsearch
es = Elasticsearch()

if __name__=='__main__':
    inFile = open("H:\Elastic\Supply\seq.txt","r")
    outFile = open("H:\Elastic\Result\log.txt","w")
    pkList = set()
    sequences = dict()
    for line in inFile:
        idx , seq1 , seq2 = map(str,line.split())
        idx , seqlist = int(idx) , list()
        seqlist.append(seq1)
        seqlist.append(seq2)
        pkList.add(idx)
        sequences[idx]=seqlist
    es.indices.create(index='mysequence', ignore=400)
 
    for pid in pkList:
        seqlist = sequences[pid]
        seq1,seq2 = seqlist[0], seqlist[1]
        es.index(index='mysequence', doc_type="sequence-type",id=pid,body={"seq1":seq1,"seq2":seq2,"match_score":0})

    #Apply Smith-Waterman and Find match-score....

    for pid in pkList:
        sequenceSets = es.get(index="mysequence",doc_type="sequence-type",id=pid)['_source']
        outFile.write(str(pid)+" "+str(sequenceSets['match_score'])+"\n")

    inFile.close()
    outFile.close()
