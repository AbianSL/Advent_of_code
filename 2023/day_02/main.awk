BEGIN {
  FS = "[:;]+";
  result = 0;
  tmp_number = 0;
}

func get_number(string) {
  match(string, /[0-9]+/);
  return substr(string, RSTART, RLENGTH);
}

{
  for (i = 1; i <= NF; i++) {
    if ($i ~ /Game [0-9]+/) {
      tmp_number = get_number($i);
    }
  }
}
