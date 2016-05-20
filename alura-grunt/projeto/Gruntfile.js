/* recebe o objeto grunt como parâmetro*/
module.exports = function(grunt) {
   grunt.initConfig({
     copy: {
           public: {
                cwd: 'public',
                src: '**',
                dest: 'dist',
                expand: true
           }
      },
      clean: {
              dist: {
                  src: 'dist'
              }
         },
      useminPrepare: {
          html: 'dist/**/*.html'
        },

      usemin: {
          html: 'dist/**/*.html'
        },
      imagemin: {
         public: {
           expand: true,
           cwd: 'dist/img',
           src: '**/*.{png,jpg,gif}',
           dest: 'dist/img'
         }
      },
      rev: {
          options: {
            encoding: 'utf8',
            algorithm: 'md5',
            length: 8
          },

          imagens: {
            src: ['dist/img/**/*.{png,jpg,gif}']
          },

          minificados: {
            src: ['dist/js/**/*.min.js', 'dist/css/**/*.min.css']
          }
    }
  });

  grunt.registerTask('dist', ['clean', 'copy']);
  grunt.registerTask('minifica', ['useminPrepare',
                                  'concat', 'uglify', 'cssmin', 'rev:imagens','rev:minificados', 'usemin', 'imagemin']);
  grunt.registerTask('default', ['dist','minifica']);

  grunt.loadNpmTasks('grunt-contrib-copy');
  grunt.loadNpmTasks('grunt-contrib-clean');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-cssmin');
  grunt.loadNpmTasks('grunt-usemin');
  grunt.loadNpmTasks('grunt-contrib-imagemin');
  grunt.loadNpmTasks('grunt-rev');
}
