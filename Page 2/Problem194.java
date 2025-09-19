/*
 * Shell
 * 
 * # NF represents the number of fields in the current record, that is, how many
 * columns are there
 * # NR indicates the number of records that have been read, which is the line
 * number
 * awk '{
 * for (i = 1; i <= NF; ++i) {
 * if (NR == 1) s[i] = $i;
 * else s[i] = s[i] " " $i;
 * }
 * } END {
 * for (i = 1; s[i] != ""; ++i) {
 * print s[i];
 * }
 * }' file.txt
 */