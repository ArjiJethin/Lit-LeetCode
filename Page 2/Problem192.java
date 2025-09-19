/*
 * 
 * 
 * # solution-2
 * # grep -e is strictly the flag for indicating the pattern you want to match
 * against.
 * # grep -E controls whether you need to escape certain special characters.
 * # grep -o means: Print only the matched (non-empty) parts of a matching line,
 * with each such part on a separate output line.
 * # sort -n, --numeric-sort, --sort=numeric
 * # sort -r, --reverse
 * grep -oE '[a-z]+' words.txt | sort | uniq -c | sort -nr | awk '{print
 * $2" "$1}'
 * 
 */