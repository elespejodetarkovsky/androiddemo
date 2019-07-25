package com.sxtsoft.countryflagsv2.model;

public class Language {

        private String name;


        public Language(){

        }

        public Language(String name) {
                this.name = name;
        }


        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }


        @Override
        public String toString() {
                return "Language{" +
                        "name='" + name + '\'' +
                        '}';
        }
}
