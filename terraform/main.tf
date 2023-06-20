terraform {
  required_providers {
    aws = {
      source = "hashicorp/aws"
      version = "5.2.0"
    }
  }
}

provider "aws" {
  region = "eu-west-2"
  access_key = "test"
  secret_key = "test"
}

resource "aws_instance" "example" {
  ami           = "ami-0e603d96bf395bc01"  # ID AMI dla odpowiedniego obrazu systemu operacyjnego
  instance_type = "t2.micro"
  key_name      = "skytrader24-terraform"   # Nazwa pary kluczy EC2

  tags = {
    Name = "ExampleInstance"
  }
}

