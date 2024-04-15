resource "local_file" "foo" {
  content  = "Time is: ${plantimestamp()} for dev"
  filename = "${path.module}/time"
}

terraform {
  backend "local" {
    path = "terraform.tfstate"
  }
}
