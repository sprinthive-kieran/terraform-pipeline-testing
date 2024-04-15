resource "local_file" "foo" {
  content  = "Time is: ${plantimestamp()}"
  filename = "${path.module}/time"
}
