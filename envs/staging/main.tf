resource "local_file" "foo" {
  content  = "Time is: ${plantimestamp()} for staging"
  filename = "${path.module}/time"
}

terraform {
  backend "local" {
    path = "terraform.tfstate"
  }
}
