#README

- 言語処理100本ノックのプログラムをJavaで書いた．
- http://www.cl.ecei.tohoku.ac.jp/index.php?NLP%20100%20Drill%20Exercises

## 課題とプログラム名の対応
### 第1セット
1. LineCount.java  
 - wc -l adrress.txt 
2. Tab2Space.java 
3. ExtractCol.java
4. PasteCols.java
5. PrintHeadSent.java 
6. PrintTailSent.java
7. UniqNum.java
 - cut -f1 adrress.txt | sort | uniq | wc -l
8. DicSort2Col.java 
9. ReverseSort.java
10. WordFrequency.java
 - sort col2.txt | uniq -c | sort -r

### 第2セット
00. ExtensionBufferedReader.java 
 - http://takaharukobayashi.blogspot.jp/2013/06/javabufferedbreaderreadline.html を元に\nで一行読み込むようにする
 - \rでは改行しない 
11. KakusanKibou.java
 - grep "拡散希望" tweets.txt
12. EOSNow.java
 - grep "なう$" tweets.txt
13. ExtractRT.java
14. ExtractUser.java
